package com.cti.dao;

import java.util.List;

import com.cti.model.User;
import com.cti.model.UserDetail;

public interface UserDAO {
	
	public boolean saveUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean updatePassword(User user);
	
	public boolean removeUser(String username);
	
	public User getUserById(String username);

	public List<User> listUsers();	
	
	public List<User> listUsers(List<String> userList);

	List<User> listAllUsers(String username);

	List<UserDetail> listUser(String username);
}
