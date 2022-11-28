package com.Soppify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.models.User;

public interface CustomerRepo extends JpaRepository<User, String>{
   
	
	public User findByUsername(String username);
}
