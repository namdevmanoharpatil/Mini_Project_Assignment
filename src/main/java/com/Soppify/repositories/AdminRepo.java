package com.Soppify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.models.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{
 
	public Admin findByUsername(String username);
	
}
