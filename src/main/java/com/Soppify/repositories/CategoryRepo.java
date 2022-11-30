package com.Soppify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, String>{

	public Category findByCategoryName(String name);
	
}
