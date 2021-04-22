package com.intecsec.mall.gateway.service.impl;

import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.user.UserClient;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 15:03
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
    public List<UserDTO> getUserList(int page, int pageSize) {
        return userClient.getUserList(page, pageSize);
    }

    @Override
    public int update(Long userId, UserDTO userDTO) {
        return userClient.update(userId, userDTO);
    }

    @Override
    public int delete(Long userId) {
        return userClient.delete(userId);
    }

    @Override
    public UserConsigneeDTO getUserConsignee(Long id) {
        return userClient.getUserConsignee(id);
    }
}
