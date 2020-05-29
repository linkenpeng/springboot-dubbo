package com.intecsec.mall.order.service;

import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;

/**
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
public interface UserService {

    UserDTO getUser(Long userId);

    UserConsigneeDTO getUserConsignee(Long id);
}
