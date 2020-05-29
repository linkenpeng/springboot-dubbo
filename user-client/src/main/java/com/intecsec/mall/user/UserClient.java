package com.intecsec.mall.user;

import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-28 18:51
 **/
public interface UserClient {

    UserDTO getUser(Long userId);

    List<UserDTO> getUserList(int page, int pageSize);

    int update(Long userId, UserDTO userDTO);

    int delete(Long userId);

    UserConsigneeDTO getUserConsignee(Long id);

}
