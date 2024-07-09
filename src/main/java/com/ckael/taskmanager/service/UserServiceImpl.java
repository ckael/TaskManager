package com.ckael.taskmanager.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ckael.taskmanager.model.Role;
import com.ckael.taskmanager.model.UserEntity;
import com.ckael.taskmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	UserRepository rep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = rep.findByUser_name(username).orElseThrow(()->new UsernameNotFoundException(username+"Not found"));
		return new User(user.getUser_name(),user.getUser_password(),mapRoleAuth(user.getUser_Roles()));	
	}
	private Collection<GrantedAuthority> mapRoleAuth(List<Role> roles)
	{
		
		return roles.stream().map(Role->new SimpleGrantedAuthority(Role.getRole_name())).collect(Collectors.toList());
	}

	@Override
	public UserEntity saveUser(UserEntity u) {
		
		return rep.save(u);
	}

	@Override
	public UserEntity editUser(UserEntity u) {
		
		return rep.save(u);
	}

	@Override
	public void deleteUser(String Id) {
		rep.deleteById(Id);

	}

	@Override
	public void deleteUser(UserEntity u) {
		rep.delete(u);

	}

	@Override
	public List<UserEntity> listUsers() {
		
		return rep.findAll();
	}

	

}
