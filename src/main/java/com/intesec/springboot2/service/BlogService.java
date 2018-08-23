package com.intesec.springboot2.service;

import com.github.pagehelper.PageInfo;
import com.intesec.springboot2.model.Blog;

/**
 * @description: 博客
 * @author: peter.peng
 * @create: 2018-08-23 16:46
 **/
public interface BlogService {
    int addBlog(Blog blog);

    PageInfo<Blog> getBlogList(int pageNum, int pageSize);
}
