package com.intecsec.mall.gateway.service;

import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 10:50
 **/
public interface OrderService {

    OrderDTO getOrder(Long id);

    List<OrderDTO> getOrderList(int page, int pageSize);

    OrderDTO getUserOrder(Long id, Long userId);

    List<OrderDTO> getUserOrderList(Long userId, int page,int pageSize);

    OrderDTO addOrder(AddOrderDTO addOrderDTO);
}
