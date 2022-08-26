package com.lucifer.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.lab.entities.Comment;

public interface CommentRepo  extends JpaRepository<Comment, Integer>{

}
