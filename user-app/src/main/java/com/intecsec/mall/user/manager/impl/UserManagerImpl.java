package com.intecsec.mall.user.manager.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.entity.IdGen;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.entity.UserConsignee;
import com.intecsec.mall.user.manager.UserManager;
import com.intecsec.mall.user.mapper.IdGenMapper;
import com.intecsec.mall.user.mapper.UserConsigneeMapper;
import com.intecsec.mall.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
@Repository
@Slf4j
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserConsigneeMapper userConsigneeMapper;

    @Autowired
    private IdGenMapper idGenMapper;

    @Override
    public UserDTO getUser(Long userId) {
        idGen();

        User user = userMapper.selectByPrimaryKey(userId);
        return DOUtils.copy(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUserList(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<User> userList = userMapper.getList(offset, pageSize);
        return DOUtils.copyList(userList, UserDTO.class);
    }

    private void idGen() {
        String idName = "user_id";
        IdGen idGen = idGenMapper.getById(idName);
        idGenMapper.updateNextStart(idName, idGen.getNextStartId());
        // Just slow the transaction
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.info("error", e);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(Long userId, UserDTO userDTO) {
        idGen();

        User user = DOUtils.copy(userDTO, User.class);
        user.setId(userId);
        user.setGmtUpdate(new Date());

        UserConsignee userConsignee = new UserConsignee();
        userConsignee.setUserId(userId);
        userConsignee.setMobile("15876505396");
        int updateResult = userConsigneeMapper.updateByPrimaryKeySelective(userConsignee);
        log.info("updateResult:{}", updateResult);

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
