package com.lucifer.lab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.lab.entities.Category;
import com.lucifer.lab.entities.Post;
import com.lucifer.lab.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	

}
