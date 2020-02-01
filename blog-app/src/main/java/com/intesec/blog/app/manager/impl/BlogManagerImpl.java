package com.intesec.blog.app.manager.impl;

import com.intesec.blog.app.entity.Blog;
import com.intesec.blog.app.manager.BlogManager;
import com.intesec.blog.app.mapper.BlogMapper;
import com.intesec.blog.app.redis.RedisUtil;
import com.intesec.blog.app.rocketmq.RocketMqProducer;
import com.intesec.blog.common.dto.BlogDTO;
import com.intesec.mall.common.utils.DOUtils;
import com.intesec.mall.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 博客实现类
 * @author: peter.peng
 * @create: 2018-08-23 16:49
 **/
@Service("blogService")
@Slf4j
public class BlogManagerImpl implements BlogManager {

    @Autowired
    private BlogMapper blogMapper;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private RocketMqProducer mqProducer;

    @Override
    public int addBlog(BlogDTO blogDTO) {
        Blog blog = DOUtils.copy(blogDTO, Blog.class);
        return blogMapper.insert(blog);
    }

    @Override
    public List<BlogDTO> getBlogList(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;

        log.info("offset:{}, pageSize:{}", offset, pageSize);
        List<Blog> blogs = blogMapper.getBlogList(offset, pageSize);

        List<BlogDTO> blogDTOS = DOUtils.copyList(blogs, BlogDTO.class);
        return blogDTOS;
    }

    @Override
    public BlogDTO getOne(int id) {

        String cacheKey = "blog_" + id;

        Blog blog = null;
        try {
            blog = (Blog) redisUtil.get(cacheKey);
            mqProducer.sendMq(JsonUtils.toJson(blog));
        } catch (Exception e) {
            redisUtil.del(cacheKey);
        }

        log.info("get blog from cache: {}", JsonUtils.toJson(blog));
        if(blog == null) {
            blog = blogMapper.selectByPrimaryKey(id);
            log.info("set blog cache: {}", JsonUtils.toJson(blog));
            redisUtil.set(cacheKey, blog, 600);
        }

        return DOUtils.copy(blog, BlogDTO.class);
    }
}
