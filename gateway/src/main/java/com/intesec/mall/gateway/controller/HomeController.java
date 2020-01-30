package com.intesec.mall.gateway.controller;

import com.intesec.blog.client.BlogClient;
import com.intesec.mall.common.utils.RestResponse;
import com.intesec.mall.gateway.rpc.BlogRpc;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-10 09:58
 **/
@RestController()
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private BlogRpc blogRpc;

    @Reference(version = "1.0.0")
    private BlogClient blogClient;

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return RestResponse.success("ok");
    }

    @GetMapping("/blog")
    @ResponseBody
    public String blog() {
        return RestResponse.success(blogRpc.getOne(1));
    }

    @GetMapping("/blogInfo")
    @ResponseBody
    public String blogInfo() {
        return RestResponse.success(blogClient.getOne(1));
    }
}
