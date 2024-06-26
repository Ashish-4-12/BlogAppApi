package com.backendprojects.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendprojects.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
