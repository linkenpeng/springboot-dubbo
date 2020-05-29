package com.intecsec.mall.gateway.controller;

import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-10 09:58
 **/
@RestController()
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{itemId}")
    @ResponseBody
    public String get(@PathVariable Long itemId) {
        return RestResponse.success(itemService.itemDetail(itemId));
    }

    @ResponseBody
    @GetMapping("/list")
    public Object getBlogList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
        return RestResponse.success(itemService.itemList(pageNum, pageSize));
    }

}
