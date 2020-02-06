package com.intecsec.mall.gateway.controller;

import com.intecsec.blog.client.BlogClient;
import com.intecsec.blog.common.dto.BlogDTO;
import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @description: 博客控制器类
 * @author: peter.peng
 * @create: 2018-08-23 17:08
 **/
@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Reference(version = "1.0.0")
    private BlogClient blogClient;

    @ResponseBody
    @PostMapping("/add")
    public Object addBlog(BlogDTO blog) {
        blog.setDeleteMark((byte) 0);
        blog.setTitle(TraceUtil.currentTraceId());
        blog.setContent(TraceUtil.currentTraceId() + "内容");
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        return RestResponse.success(blogClient.addBlog(blog));
    }

    @ResponseBody
    @GetMapping("/list")
    public Object getBlogList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
        return RestResponse.success(blogClient.getBlogList(pageNum, pageSize));
    }

    @ResponseBody
    @GetMapping("/info")
    public Object getBlog(@RequestParam(name = "id", defaultValue = "1") int id) {
        return RestResponse.success(blogClient.getOne(id));
    }
}
