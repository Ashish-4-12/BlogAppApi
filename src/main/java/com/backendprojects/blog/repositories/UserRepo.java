package com.backendprojects.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendprojects.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
