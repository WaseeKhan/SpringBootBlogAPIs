package com.lucifer.lab.payloads;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Written By: Waseem
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message="Name must be min of 4 character!")
	private String name;
	
	@Email(message="Invalid E-mail!!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="Password must be between 3 to 10 character!!")
	private String password;
	
	@NotEmpty
	@Size(min=5,max=200, message="Name must be min of 4 character!")
	private String about;
	
}
