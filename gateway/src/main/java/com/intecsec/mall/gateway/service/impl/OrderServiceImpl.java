package com.intecsec.mall.gateway.service.impl;

import com.intecsec.mall.gateway.service.OrderService;
import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderClient;
import com.intecsec.mall.order.OrderDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 10:51
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0.0")
    private OrderClient orderClient;

    @Override
    public OrderDTO getOrder(Long id) {
        return orderClient.getOrder(id);
    }

    @Override
    public List<OrderDTO> getOrderList(int page, int pageSize) {
        return orderClient.getOrderList(page, pageSize);
    }

    @Override
    public OrderDTO getUserOrder(Long id, Long userId) {
        return orderClient.getUserOrder(id, userId);
    }

    @Override
    public List<OrderDTO> getUserOrderList(Long userId, int page, int pageSize) {
        return orderClient.getUserOrderList(userId, page, pageSize);
    }

    @Override
    public OrderDTO addOrder(AddOrderDTO addOrderDTO) {
        return orderClient.addOrder(addOrderDTO);
    }
}
