package com.intesec.blog.core.controller;

import com.intesec.blog.core.model.Blog;
import com.intesec.blog.core.service.BlogService;
import com.intesec.blog.core.component.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 博客控制器类
 * @author: peter.peng
 * @create: 2018-08-23 17:08
 **/
@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Resource
    private BlogService blogService;

    @Resource
    private RedisUtil redisUtil;

    @ResponseBody
    @PostMapping("/add")
    public int addBlog(Blog blog) {
        blog.setDeleteMark((byte) 0);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        return blogService.addBlog(blog);
    }

    @ResponseBody
    @GetMapping("/list")
    public Object getBlogList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
        return  blogService.getBlogList(pageNum, pageSize);
    }

    @ResponseBody
    @GetMapping("/info")
    public Object getBlog(@RequestParam(name = "id", required = true, defaultValue = "1") int id) {
        String cacheKey = "blog_" + id;

        Blog blog = null;
        try {
            blog = (Blog) redisUtil.get(cacheKey);
        } catch (Exception e) {
            redisUtil.del(cacheKey);
        }

        log.info("get blog cache: {}", blog);
        if(blog == null) {
            blog = blogService.getOne(id);
            log.info("set blog cache: {}", blog);
            redisUtil.set(cacheKey, blog, 600);
        }

        return  blogService.getOne(id);
    }
}
