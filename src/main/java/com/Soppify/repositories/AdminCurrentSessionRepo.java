package com.Soppify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.models.AdminCurrentSession;

public interface AdminCurrentSessionRepo extends JpaRepository<AdminCurrentSession, String>{

	public AdminCurrentSession findByUsername(String username);
	
}
