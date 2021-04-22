package com.intecsec.mall.order.service.impl;

import com.intecsec.mall.order.service.UserService;
import com.intecsec.mall.user.UserClient;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 10:40
 **/
@Service
public class UserServiceImpl implements UserService {

    @DubboReference(version = "1.0.0")
    private UserClient userClient;

    @Override
    public UserDTO getUser(Long userId) {
        return userClient.getUser(userId);
    }

    @Override
    public UserConsigneeDTO getUserConsignee(Long id) {
        return userClient.getUserConsignee(id);
    }
}
