package com.intecsec.mall.order.client.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.order.*;
import com.intecsec.mall.order.manager.OrderManager;
import com.intecsec.mall.order.service.ItemService;
import com.intecsec.mall.order.service.UserService;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-28 19:02
 **/
@Component
@Service(version = "1.0.0")
public class OrderClientImpl implements OrderClient {

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Override
    public OrderDTO getOrder(Long id) {
        return orderManager.getOrder(id);
    }

    @Override
    public List<OrderDTO> getOrderList(int page, int pageSize) {
        return orderManager.getOrderList(page, pageSize);
    }

    @Override
    public OrderDTO getUserOrder(Long id, Long userId) {
        return orderManager.getUserOrder(id, userId);
    }

    @Override
    public List<OrderDTO> getUserOrderList(Long userId, int page, int pageSize) {
        return orderManager.getUserOrderList(page, pageSize, userId);
    }

    @Override
    public OrderDTO addOrder(AddOrderDTO addOrderDTO) {
        OrderDTO orderDTO = new OrderDTO();

        UserConsigneeDTO userConsigneeDTO = userService.getUserConsignee(addOrderDTO.getConsignee_id());
        OrderConsigneeDTO orderConsigneeDTO = DOUtils.copy(userConsigneeDTO, OrderConsigneeDTO.class);

        orderDTO.setUserId(addOrderDTO.getUser_id());

        List<Long> itemIds = new ArrayList<>();
        Map<Long, Integer> itemNumberMap = new HashMap<>();
        for(AddOrderItemDTO addOrderItemDTO : addOrderDTO.getOrder_item_list()) {
            itemIds.add(addOrderItemDTO.getItem_id());
            itemNumberMap.put(addOrderItemDTO.getItem_id(), addOrderItemDTO.getNumber());
        }

        List<ItemDTO> itemDTOS = itemService.itemListByIds(StringUtils.join(itemIds, ","));

        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        long orderPriceAmount = 0L;
        for(ItemDTO itemDTO : itemDTOS) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setItemId(itemDTO.getId());
            orderItemDTO.setItemNum(itemNumberMap.get(itemDTO.getId()));
            orderItemDTO.setItemPrice(itemDTO.getItemPrice());
            orderItemDTO.setItemName(itemDTO.getItemName());

            orderPriceAmount += itemDTO.getItemPrice();

            orderItemDTOS.add(orderItemDTO);
        }

        orderDTO.setOrderConsignee(orderConsigneeDTO);
        orderDTO.setOrderItemList(orderItemDTOS);
        orderDTO.setPriceAmount(orderPriceAmount);
        orderDTO.setDeleteMark((byte)0);
        orderDTO.setCouponAmount(0L);
        orderDTO.setPointAmount(0L);
        orderDTO.setDiscountAmount(0L);
        orderDTO.setDeliveryFee(0L);
        orderDTO.setPayAmount(orderDTO.getPriceAmount() - orderDTO.getDiscountAmount() + orderDTO.getDeliveryFee());

        return orderManager.addOrder(orderDTO);
    }
}
