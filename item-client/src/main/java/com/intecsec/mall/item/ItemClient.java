package com.intecsec.mall.item;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-28 18:42
 **/
public interface ItemClient {

    ItemDTO itemDetail(Long itemId);

    List<ItemDTO> itemList(int page, int pageSize);

    List<ItemDTO> itemListByIds(String itemIds);

}
