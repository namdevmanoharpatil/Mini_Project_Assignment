package com.Soppify.services;

import com.Soppify.exceptions.AdminException;
import com.Soppify.exceptions.CategoryException;
import com.Soppify.exceptions.ProductException;
import com.Soppify.models.Admin;
import com.Soppify.models.AdminDto;
import com.Soppify.models.Category;
import com.Soppify.models.Product;

public interface AdminService {

	public AdminDto insertAdmin(Admin admin, String loggedInAdminid) throws AdminException;
	
	public Category insertCategory(Category category, String loggedInAdminId) throws AdminException, CategoryException;
	
	public Product insertProduct(Product product, String categoryName, String loggedInAdminId) throws AdminException, ProductException, CategoryException;
}
