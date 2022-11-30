package com.Soppify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Soppify.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

	@Query("select p from Product p where p.productName like %?1% or p.productName like %?2% or p.manufacturer like %?1% or p.manufacturer like %?2% or p.specification like %?1% or p.specification like %?2%" )
	public List<Product> searchProductsByName(String name, String modifiedName1);
	
	@Query("select p from Product p join Category c on p.category.categoryId = c.categoryId where c.categoryName like %?1% or c.categoryName like %?2%")
	public List<Product> searchProductsByCategory(String categoryName, String modifiedCategoryName);
	
}
