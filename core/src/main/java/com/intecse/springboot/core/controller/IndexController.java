package com.intecse.springboot.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 首页
 * @author: peter.peng
 * @create: 2018-08-17 15:10
 **/
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping(value = "/index")
    public @ResponseBody String index() {
        return "index";
    }
}
