package com.intecsec.blog.manager.impl;

import com.intecsec.blog.entity.Blog;
import com.intecsec.blog.manager.BlogManager;
import com.intecsec.blog.mapper.BlogMapper;
import com.intecsec.blog.mq.consumer.BlogMqTopicTag;
import com.intecsec.blog.common.dto.BlogDTO;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.redis.RedisManager;
import com.intecsec.mall.rocketmq.RocketMqProducer;
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
@Service()
@Slf4j
public class BlogManagerImpl implements BlogManager {

    @Autowired
    private BlogMapper blogMapper;

    @Resource
    private RedisManager redisManager;

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
            blog = (Blog) redisManager.get(cacheKey);
            log.info("get blog from cache key:{}, value:{}", cacheKey, JsonUtils.toJson(blog));
        } catch (Exception e) {
            redisManager.del(cacheKey);
        }

        if(blog == null) {
            blog = blogMapper.selectByPrimaryKey(id);
            log.info("set blog cache: {}", JsonUtils.toJson(blog));
            redisManager.set(cacheKey, blog, 600);
        }

        mqProducer.sendMq(BlogMqTopicTag.BLOG_INFO_MQ, String.valueOf(blog.getId()), JsonUtils.toJson(blog));

        return DOUtils.copy(blog, BlogDTO.class);
    }
}
