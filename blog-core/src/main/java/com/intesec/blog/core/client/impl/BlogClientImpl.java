package com.intesec.blog.core.client.impl;

import com.github.pagehelper.PageInfo;
import com.intesec.blog.client.BlogClient;
import com.intesec.blog.common.dto.BlogDTO;
import com.intesec.blog.core.model.Blog;
import com.intesec.blog.core.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: blog服务实现类
 * @author: peter.peng
 * @create: 2018-10-26 11:50
 **/
@Component
public class BlogClientImpl implements BlogClient {
    @Autowired
    private BlogService blogService;

    @Override
    public int addBlog(BlogDTO blogDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        return blogService.addBlog(blog);
    }

    @Override
    public List<BlogDTO> getBlogList(int pageNum, int pageSize) {
        PageInfo<Blog> blogPageInfo = blogService.getBlogList(pageNum, pageSize);
        List<Blog> blogs = blogPageInfo.getList();
        List<BlogDTO> blogDTOS = new ArrayList<>();
        for(Blog blog : blogs) {
            BlogDTO blogDTO = new BlogDTO();
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTOS.add(blogDTO);
        }
        return blogDTOS;
    }

    @Override
    public BlogDTO getOne(int id) {
        Blog blog = blogService.getOne(id);
        BlogDTO blogDTO = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDTO);
        return blogDTO;
    }
}
