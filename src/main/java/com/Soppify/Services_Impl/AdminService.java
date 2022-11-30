package com.Soppify.Services_Impl;

import com.Soppify.Entity.Admin;
import com.Soppify.Entity.AdminDto;
import com.Soppify.Entity.Category;
import com.Soppify.Entity.Product;
import com.Soppify.Exceptions.AdminException;
import com.Soppify.Exceptions.CategoryException;
import com.Soppify.Exceptions.ProductException;

public interface AdminService {

	public AdminDto insertAdmin(Admin admin, String loggedInAdminid) throws AdminException;
	
	public Category insertCategory(Category category, String loggedInAdminId) throws AdminException, CategoryException;
	
	public Product insertProduct(Product product, String categoryName, String loggedInAdminId) throws AdminException, ProductException, CategoryException;
}
