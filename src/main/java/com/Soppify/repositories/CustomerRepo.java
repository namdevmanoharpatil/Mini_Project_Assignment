package com.Soppify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.Entity.User;

public interface CustomerRepo extends JpaRepository<User, String>{
   
	
	public User findByUsername(String username);
}
