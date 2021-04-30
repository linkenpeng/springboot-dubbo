package com.intecsec.mall.gateway.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author Peter.Peng
 * @date 2021/4/30
 */
@Data
public class UserInfo extends User {
	private String id;
	private String name;
	private String companyId;

	public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
}
