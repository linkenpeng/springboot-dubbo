package com.intecsec.mall.user.client.impl;

import com.intecsec.mall.user.UserClient;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.manager.UserConsigneeManager;
import com.intecsec.mall.user.manager.UserManager;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-28 18:54
 **/
@Component
@DubboService(version = "1.0.0")
public class UserClientImpl implements UserClient {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserConsigneeManager userConsigneeManager;

    @Override
    public UserDTO getUser(Long userId) {
        return userManager.getUser(userId);
    }

    @Override
    public UserDTO getUser(String userName) {
        return userManager.getUser(userName);
    }

    @Override
    public List<UserDTO> getUserList(int page, int pageSize) {
        return userManager.getUserList(page, pageSize);
    }

    @Override
    public int update(Long userId, UserDTO userDTO) {
        return userManager.update(userId, userDTO);
    }

    @Override
    public int delete(Long userId) {
        return userManager.delete(userId);
    }

    @Override
    public UserConsigneeDTO getUserConsignee(Long id) {
        return userConsigneeManager.getOne(id);
    }
}
