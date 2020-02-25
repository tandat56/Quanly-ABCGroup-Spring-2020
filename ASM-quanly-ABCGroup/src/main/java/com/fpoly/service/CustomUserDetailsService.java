package com.fpoly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.fpoly.constant.SystemConstant;
import com.fpoly.dto.MyUser;
import com.fpoly.entity.RoleEntity;
import com.fpoly.entity.UserEntity;
import com.fpoly.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		// put thông tin vào security để duy trì thông tin đó khi user đăng nhập vào hệ thống
		
		// vai trò (1 user có thể có nhiều vai trò)
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//lấy role trong thằng userEntity ra
		for (RoleEntity role: userEntity.getRole()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		//lưu thông tin người dùng
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
