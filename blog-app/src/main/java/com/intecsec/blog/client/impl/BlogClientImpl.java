package com.intecsec.blog.client.impl;

import com.intecsec.blog.client.BlogClient;
import com.intecsec.blog.common.dto.BlogDTO;
import com.intecsec.blog.manager.BlogManager;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: blog服务实现类
 * @author: peter.peng
 * @create: 2018-10-26 11:50
 **/
@Component
@DubboService(version = "1.0.0")
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
