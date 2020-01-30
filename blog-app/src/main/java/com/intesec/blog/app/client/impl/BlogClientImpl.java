package com.intesec.blog.app.client.impl;

import com.intesec.blog.client.BlogClient;
import com.intesec.blog.common.dto.BlogDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: blog服务实现类
 * @author: peter.peng
 * @create: 2018-10-26 11:50
 **/
@Component
@Service(version = "1.0.0")
public class BlogClientImpl implements BlogClient {

    @Override
    public int addBlog(BlogDTO blogDTO) {
        return 1;
    }

    @Override
    public List<BlogDTO> getBlogList(int pageNum, int pageSize) {
        List<BlogDTO> blogDTOS = new ArrayList<>();
        return blogDTOS;
    }

    @Override
    public BlogDTO getOne(int id) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setTitle("blog title");
        blogDTO.setCreateTime(new Date());
        return blogDTO;
    }
}
