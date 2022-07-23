package com.lucifer.lab.services;

import java.util.List;


import com.lucifer.lab.payloads.PostDto;
import com.lucifer.lab.payloads.PostResponse;

public interface PostService {
	
	
	//create post
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	
	//get all posts
	PostResponse getAllPost(Integer pageNo, Integer pageSize,String sortBy, String sortDir);
	
	
	//get single post
	PostDto  getPostById(Integer postId);
	
	
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	
	//Search Posts
	List<PostDto> searchPosts(String keyword);
	
	
	

}
