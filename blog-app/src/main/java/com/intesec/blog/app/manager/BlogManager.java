package com.intesec.blog.app.manager;

import com.intesec.blog.common.dto.BlogDTO;

import java.util.List;

/**
 * @description: 博客
 * @author: peter.peng
 * @create: 2018-08-23 16:46
 **/
public interface BlogManager {
    int addBlog(BlogDTO blogDTO);

    List<BlogDTO> getBlogList(int pageNum, int pageSize);

    BlogDTO getOne(int id);
}
