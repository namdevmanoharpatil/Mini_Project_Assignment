package com.Soppify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.Entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{
 
	public Admin findByUsername(String username);
	
}
