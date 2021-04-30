package com.intecsec.mall.gateway.service;

import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-29 15:00
 **/
public interface UserService {

    UserDTO getUser(Long userId);

    UserDTO getUser(String userName);

    List<UserDTO> getUserList(int page, int pageSize);

    int update(Long userId, UserDTO userDTO);

    int delete(Long userId);

    UserConsigneeDTO getUserConsignee(Long id);

}
