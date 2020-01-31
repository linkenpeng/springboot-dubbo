package com.intesec.blog.app.client.impl;

import com.intesec.blog.app.manager.BlogManager;
import com.intesec.blog.client.BlogClient;
import com.intesec.blog.common.dto.BlogDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: blog服务实现类
 * @author: peter.peng
 * @create: 2018-10-26 11:50
 **/
@Component
@Service(version = "1.0.0")
public class BlogClientImpl implements BlogClient {
    @Autowired
    private BlogManager blogManager;

    @Override
    public int addBlog(BlogDTO blogDTO) {
        return blogManager.addBlog(blogDTO);
    }

    @Override
    public List<BlogDTO> getBlogList(int pageNum, int pageSize) {
        return blogManager.getBlogList(pageNum, pageSize);
    }

    @Override
    public BlogDTO getOne(int id) {
        return blogManager.getOne(id);
    }
}
