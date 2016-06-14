package com.cti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cti.model.User;
import com.cti.model.UserDetail;

@Transactional
public interface UserService {
	
public boolean saveUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean updatePassword(User user);
	
	public boolean removeUser(String username);
	
	public User getUserById(String username);

	public List<User> listUsers();	
	
	public List<UserDetail> listUser(String username);	
	
	public List<User> listAllUsers(String username);
	
	public List<User> listUsers(List<String> userList);
	
	
}
