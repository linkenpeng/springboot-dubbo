package com.intesec.springboot2.controller;

import com.intesec.springboot2.model.Blog;
import com.intesec.springboot2.service.BlogService;
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
public class BlogController {
    @Resource
    private BlogService blogService;

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
}
