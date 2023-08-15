package com.lucifer.lab.payloads;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Written By: Waseem
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Validated
public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message="Name must be min of 4 character!")
	private String name;
	
	@Email(message="Invalid E-mail!!", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotEmpty(message = "Email is required")

	private String email;
	
	@NotNull
	@Size(min=3, max=10, message="Password must be between 3 to 10 character!!")
	private String password;
	

	@Size(min=5,max=200, message="Please enter at-least 5 word about you!")
	private String about;
	
	private Set<RoleDto> roles  = new HashSet<>();


	//Hiding password from user details
	@JsonIgnore
	public String getPassword(){
		return this.password;
	}

	//Setting password
	@JsonProperty
	public void setPassword(String password){
		this.password=password;
	}
}
