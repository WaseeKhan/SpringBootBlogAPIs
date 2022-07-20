package com.lucifer.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.lab.entities.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
