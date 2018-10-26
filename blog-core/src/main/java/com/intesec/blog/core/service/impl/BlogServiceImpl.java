package com.intesec.blog.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.intesec.blog.core.component.RedisUtil;
import com.intesec.blog.core.mapper.BlogMapper;
import com.intesec.blog.core.model.Blog;
import com.intesec.blog.core.service.BlogService;
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
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public int addBlog(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public PageInfo<Blog> getBlogList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        int offset = (pageNum - 1) * pageSize;
        List<Blog> blogs = blogMapper.getBlogList(offset, pageSize);
        PageInfo<Blog> result = new PageInfo<>(blogs);
        return result;
    }

    @Override
    public Blog getOne(int id) {

        String cacheKey = "blog_" + id;

        Blog blog = null;
        try {
            blog = (Blog) redisUtil.get(cacheKey);
        } catch (Exception e) {
            redisUtil.del(cacheKey);
        }

        log.info("get blog cache: {}", blog);
        if(blog == null) {
            blog = blogMapper.selectByPrimaryKey(id);
            log.info("set blog cache: {}", blog);
            redisUtil.set(cacheKey, blog, 600);
        }

        return blog;
    }
}
