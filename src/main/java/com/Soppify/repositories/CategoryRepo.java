package com.Soppify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.models.Category;

public interface CategoryRepo extends JpaRepository<Category, String>{

	public Category findByCategoryName(String name);
	
}
