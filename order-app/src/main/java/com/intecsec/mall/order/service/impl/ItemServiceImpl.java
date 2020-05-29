package com.intecsec.mall.order.service.impl;

import com.intecsec.mall.item.ItemClient;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.order.service.ItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 10:40
 **/
@Service
public class ItemServiceImpl implements ItemService {
    @Reference(version = "1.0.0")
    private ItemClient itemClient;

    @Override
    public List<ItemDTO> itemListByIds(String itemIds) {
        return itemClient.itemListByIds(itemIds);
    }

}
