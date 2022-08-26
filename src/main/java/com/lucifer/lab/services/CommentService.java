package com.lucifer.lab.services;

import com.lucifer.lab.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto comment, Integer postId);
	
	void deleteComment(Integer commentId);

}
