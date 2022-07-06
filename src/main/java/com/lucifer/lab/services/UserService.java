package com.lucifer.lab.services;
//Written By: Waseem

import com.lucifer.lab.payloads.UserDto;
import java.util.List;


public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto  user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

	

}
