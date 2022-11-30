package com.Soppify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.Entity.AdminCurrentSession;

public interface AdminCurrentSessionRepo extends JpaRepository<AdminCurrentSession, String>{

	public AdminCurrentSession findByUsername(String username);
	
}
