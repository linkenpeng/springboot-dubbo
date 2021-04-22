package com.intecsec.mall.gateway.service.impl;

import com.intecsec.blog.client.BlogClient;
import com.intecsec.blog.common.dto.BlogDTO;
import com.intecsec.mall.gateway.service.BlogService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-29 14:02
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @DubboReference(version = "1.0.0")
    private BlogClient blogClient;

    @Override
    public int addBlog(BlogDTO blogDTO) {
        return blogClient.addBlog(blogDTO);
    }

    @Override
    public List<BlogDTO> getBlogList(int pageNum, int pageSize) {
        return blogClient.getBlogList(pageNum, pageSize);
    }

    @Override
    public BlogDTO getOne(int id) {
        return blogClient.getOne(id);
    }
}
