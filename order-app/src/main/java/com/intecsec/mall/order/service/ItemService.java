package com.intecsec.mall.order.service;


import com.intecsec.mall.item.ItemDTO;

import java.util.List;

/**
 * @description: Feign 是一个声明式的Web Service客户端， 目的是让webservice调用更简单
 * Feign 整合了 Ribbon和Hystrix
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
public interface ItemService {

    List<ItemDTO> itemListByIds(String itemIds);
}
