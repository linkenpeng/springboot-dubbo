package com.intesec.blog.core.controller;

import com.intesec.blog.client.BlogClient;
import com.intesec.blog.common.dto.BlogDTO;
import com.intesec.common.utils.ResponseUtils;
import com.intesec.common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BlogClient blogClient;

    @ResponseBody
    @PostMapping("/add")
    public Object addBlog(BlogDTO blog) {
        blog.setDeleteMark((byte) 0);
        blog.setTitle(TraceUtil.currentTraceId());
        blog.setContent(TraceUtil.currentTraceId() + "内容");
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        return ResponseUtils.getSuccessApiResponseStr(blogClient.addBlog(blog));
    }

    @ResponseBody
    @GetMapping("/list")
    public Object getBlogList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
        return ResponseUtils.getSuccessApiResponseStr(blogClient.getBlogList(pageNum, pageSize));
    }

    @ResponseBody
    @GetMapping("/info")
    public Object getBlog(@RequestParam(name = "id", required = true, defaultValue = "1") int id) {
        return  ResponseUtils.getSuccessApiResponseStr(blogClient.getOne(id));
    }
}
