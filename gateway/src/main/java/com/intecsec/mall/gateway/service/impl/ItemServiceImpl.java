package com.intecsec.mall.gateway.service.impl;

import com.intecsec.mall.gateway.service.ItemService;
import com.intecsec.mall.item.ItemClient;
import com.intecsec.mall.item.ItemDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 15:07
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @DubboReference(version = "1.0.0")
    private ItemClient itemClient;

    @Override
    public ItemDTO itemDetail(Long itemId) {
        return itemClient.itemDetail(itemId);
    }

    @Override
    public List<ItemDTO> itemList(int page, int pageSize) {
        return itemClient.itemList(page, pageSize);
    }

    @Override
    public List<ItemDTO> itemListByIds(String itemIds) {
        return itemClient.itemListByIds(itemIds);
    }
}
