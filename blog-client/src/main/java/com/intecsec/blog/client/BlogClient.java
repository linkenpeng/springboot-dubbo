package com.intecsec.blog.client;

import com.intecsec.blog.common.dto.BlogDTO;

import java.util.List;

/**
 * @description: Blog的RPC接口
 * @author: peter.peng
 * @create: 2018-10-26 11:43
 **/
public interface BlogClient {
    int addBlog(BlogDTO blogDTO);

    List<BlogDTO> getBlogList(int pageNum, int pageSize);

    BlogDTO getOne(int id);
}
