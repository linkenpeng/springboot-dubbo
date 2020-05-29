package com.intecsec.mall.gateway.service;

import com.intecsec.blog.common.dto.BlogDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-29 14:01
 **/
public interface BlogService {

    int addBlog(BlogDTO blogDTO);

    List<BlogDTO> getBlogList(int pageNum, int pageSize);

    BlogDTO getOne(int id);
}
