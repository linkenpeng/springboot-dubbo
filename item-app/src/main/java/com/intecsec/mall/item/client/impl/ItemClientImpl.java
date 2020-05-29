package com.intecsec.mall.item.client.impl;

import com.intecsec.mall.item.ItemClient;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.item.manager.ItemManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-28 18:44
 **/
@Component
@Service(version = "1.0.0")
public class ItemClientImpl implements ItemClient {

    @Autowired
    private ItemManager itemManager;

    @Override
    public ItemDTO itemDetail(Long itemId) {
        return itemManager.itemDetail(itemId);
    }

    @Override
    public List<ItemDTO> itemList(int page, int pageSize) {
        return itemManager.itemList(page, pageSize);
    }

    @Override
    public List<ItemDTO> itemListByIds(String itemIds) {
        List<Long> ids = new ArrayList<>();
        if(StringUtils.isNotEmpty(itemIds)) {
            String idSplit[] = StringUtils.split(itemIds, ",");
            for(String id : idSplit) {
                ids.add(Long.parseLong(id));
            }
        }

        return itemManager.getItemListByIds(ids);
    }
}
