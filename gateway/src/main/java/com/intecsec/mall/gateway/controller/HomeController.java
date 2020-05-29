package com.intecsec.mall.gateway.controller;

import com.intecsec.mall.common.utils.RestResponse;
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
public class HomeController extends BaseController {

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return RestResponse.success("ok");
    }
}
