package com.lucifer.lab.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.lucifer.lab.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import com.lucifer.lab.exceptions.ApiException;
import com.lucifer.lab.payloads.JwtAuthRequest;
import com.lucifer.lab.payloads.JwtAuthResponse;
import com.lucifer.lab.payloads.UserDto;
import com.lucifer.lab.security.JwtTokenHelper;
import com.lucifer.lab.services.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("/api/v1/auth/")

public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		
		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);

		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		//added to get user details also for ui
		response.setUser(this.modelMapper.map((User)userDetails, UserDto.class));
		//end
		return new ResponseEntity<JwtAuthResponse> (response,HttpStatus.OK);
	}
	


	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			this.authenticationManager.authenticate(authenticationToken);
		}
			catch(Exception e) {
				System.out.println("Invalid Credentials ");
				throw new ApiException("Invalid username or password!!");
			}
			
	}
	
	//register new user API
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto userDto){
		UserDto registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);

	}

}
