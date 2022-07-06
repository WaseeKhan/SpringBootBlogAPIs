package com.lucifer.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucifer.lab.repositories.UserRepo;

@SpringBootTest
class SpringBlogApplicationTests {
	
	@Autowired
	private UserRepo  userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String calssName = this.userRepo.getClass().getName();
		String packName = this.userRepo.getClass().getPackageName();
		System.out.println(calssName);
		System.out.println(packName);
		System.out.println("-------------------------------------------------------------------------------");
	}

}
