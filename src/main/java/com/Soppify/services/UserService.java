package com.Soppify.services;

import java.util.List;

import com.Soppify.exceptions.CategoryException;
import com.Soppify.exceptions.CustomerException;
import com.Soppify.exceptions.ProductException;
import com.Soppify.models.Product;

public interface UserService {

	
	public List<Product> searchProductsByname(String name, String loggedInUserId) throws ProductException, CustomerException;
	
	public List<Product> searchProductByCategory(String categoryName, String loggedInUserId) throws CategoryException, ProductException, CustomerException;
	
	public Product addRating(String productId, String loggedInUserId, Double rating) throws ProductException, CustomerException;
	
	public List<Product> sortProductsByPriceHighToLow(List<Product> products) throws ProductException;
	
	public List<Product> sortProductsByPriceLowToHigh(List<Product> products) throws ProductException;
	
	public List<Product> sortProductsByRatingsHighToLow(List<Product> products) throws ProductException;
	
	public List<Product> sortProductsByRatingsLowToHigh(List<Product> products) throws ProductException;
	
	public Product getProductDetailsById(String id, String loggedInUserId) throws ProductException, CustomerException;
	
	public Product addToCart(String productId, String loggedInId, Integer quantity) throws ProductException, CustomerException;
	
}
