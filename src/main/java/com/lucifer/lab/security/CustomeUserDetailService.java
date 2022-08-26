package com.lucifer.lab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucifer.lab.entities.User;
import com.lucifer.lab.exceptions.ResourceNotFoundException;
import com.lucifer.lab.repositories.UserRepo;

@Service
public class CustomeUserDetailService  implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Loading user name from DB
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email : "+username, 0));
		return user;
	}

}
