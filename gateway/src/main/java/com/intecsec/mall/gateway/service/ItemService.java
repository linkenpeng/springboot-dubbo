package com.intecsec.mall.gateway.service;

import com.intecsec.mall.item.ItemDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 15:05
 **/
public interface ItemService {

    ItemDTO itemDetail(Long itemId);

    List<ItemDTO> itemList(int page, int pageSize);

    List<ItemDTO> itemListByIds(String itemIds);

}
