package com.intecsec.mall.gateway.controller;

import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.OrderService;
import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 11:00
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/add")
    public Object addOrder(@RequestBody AddOrderDTO addOrderDTO) {
        addOrderDTO.setUser_id(userId);
        log.info("addOrderDTO:{}", JsonUtils.toJson(addOrderDTO));
        OrderDTO orderDTO = orderService.addOrder(addOrderDTO);
        return RestResponse.success(orderDTO);
    }

    @ResponseBody
    @GetMapping("/list")
    public Object getOrderList(@RequestParam(name = "page_num", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "page_size", required = false, defaultValue = "20") int pageSize) {
        return RestResponse.success(orderService.getOrderList(pageNum, pageSize));
    }

    @ResponseBody
    @GetMapping("/get/{orderId}")
    public Object getOrder(@PathVariable Long orderId) {
        return RestResponse.success(orderService.getOrder(orderId));
    }

    @ResponseBody
    @GetMapping("/user/list")
    public Object getUserOrderList(@RequestParam(name = "page_num", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(name = "page_size", required = false, defaultValue = "20") int pageSize) {
        return RestResponse.success(orderService.getUserOrderList(userId, pageNum, pageSize));
    }

    @ResponseBody
    @GetMapping("/user/get/{orderId}")
    public Object getUserOrder(@PathVariable Long orderId) {
        return RestResponse.success(orderService.getUserOrder(userId, orderId));
    }
}
