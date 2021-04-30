package com.intecsec.mall.gateway.service.impl;

import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.gateway.vo.UserInfo;
import com.intecsec.mall.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Peter.Peng
 * @date 2021/4/30
 * https://blog.csdn.net/qq_41566980/article/details/108284880
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDTO userDTO = userService.getUser(userName);
		if(userDTO != null) {
			UserInfo userInfo = new UserInfo(userDTO.getUserName(),
					userDTO.getPassword(),
					AuthorityUtils.commaSeparatedStringToAuthorityList(userDTO.getRole()));
			return userInfo;
		}

		return null;
	}
}
