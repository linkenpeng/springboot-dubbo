package com.intecsec.mall.gateway.rpc.impl;

import com.intecsec.blog.client.BlogClient;
import com.intecsec.blog.common.dto.BlogDTO;
import com.intecsec.mall.gateway.rpc.BlogRpc;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-29 14:02
 **/
@Component
public class BlogRpcImpl implements BlogRpc {
    @Reference(version = "1.0.0")
    private BlogClient blogClient;

    @Override
    public int addBlog(BlogDTO blogDTO) {
        return 0;
    }

    @Override
    public List<BlogDTO> getBlogList(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public BlogDTO getOne(int id) {
        return blogClient.getOne(id);
    }
}
