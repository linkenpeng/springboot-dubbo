package com.intecsec.mall.order;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-28 18:59
 **/
public interface OrderClient {

    OrderDTO getOrder(Long id);

    List<OrderDTO> getOrderList(int page, int pageSize);

    OrderDTO getUserOrder(Long id, Long userId);

    List<OrderDTO> getUserOrderList(Long userId, int page,int pageSize);

    OrderDTO addOrder(AddOrderDTO addOrderDTO);
}
