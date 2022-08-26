package com.lucifer.lab;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lucifer.lab.config.AppConstants;
import com.lucifer.lab.entities.Role;
import com.lucifer.lab.repositories.RoleRepo;


@SpringBootApplication
public class SpringBlogApplication implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBlogApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------------- Password Generated for give String ---------------");
		System.out.println(this.passwordEncoder.encode("ehtesham"));	
		
		try {
			
			Role adminRole = new Role();
			adminRole.setId(AppConstants.ADMIN_USER);
			adminRole.setName("ROLE_ADMIN");
			
			Role normalRole = new Role();
			normalRole.setId(AppConstants.NORMAL_USER);
			normalRole.setName("ROLE_NORMAL");
			
			java.util.List<Role> roles = java.util.List.of(adminRole,normalRole);
			java.util.List<Role> result = this.roleRepo.saveAll(roles);
			
			result.forEach(r->{
				System.out.println(r.getName());
			});
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	//need to implements,  ADMIN user create  automatically here same as above 
}
