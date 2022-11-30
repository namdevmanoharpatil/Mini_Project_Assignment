package com.Soppify.Services_Impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Soppify.Comparators.HighToLowByPrice;
import com.Soppify.Comparators.HighToLowByRatings;
import com.Soppify.Comparators.LowToHighByPrice;
import com.Soppify.Comparators.LowToHighByRatings;
import com.Soppify.Entity.Category;
import com.Soppify.Entity.CustomerCurrentSession;
import com.Soppify.Entity.Product;
import com.Soppify.Entity.User;
import com.Soppify.Exceptions.CategoryException;
import com.Soppify.Exceptions.CustomerException;
import com.Soppify.Exceptions.ProductException;
import com.Soppify.Repositories.CategoryRepo;
import com.Soppify.Repositories.CustomerCurrentSessionRepo;
import com.Soppify.Repositories.CustomerRepo;
import com.Soppify.Repositories.ProductRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CustomerCurrentSessionRepo userSessionRepo;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Product> searchProductsByname(String name, String loggedInUserId)
			throws ProductException, CustomerException {
		// TODO Auto-generated method stub
		Optional<User> uOptional = customerRepo.findById(loggedInUserId);

		if (uOptional.get() != null) {
			Optional<CustomerCurrentSession> cOptional = userSessionRepo.findById(loggedInUserId);
			if (cOptional.get() != null) {
				return productRepo.searchProductsByName(name, name.split(" ")[0]);
			}
			throw new CustomerException("Customer with id " + loggedInUserId + " is not logged in");
		}
		throw new CustomerException("No customer exists with the user id " + loggedInUserId);
	}

	@Override
	public List<Product> searchProductByCategory(String categoryName, String loggedInUserId)
			throws CategoryException, ProductException, CustomerException {
		if (customerRepo.findById(loggedInUserId).get() != null) {

			if (userSessionRepo.findById(loggedInUserId).get() != null) {
				Category c = categoryRepo.findByCategoryName(categoryName);

				if (c != null) {
					return productRepo.searchProductsByCategory(categoryName, categoryName.split(" ")[0]);
				}
				throw new CategoryException("No category is present with the name " + categoryName);
			}
			throw new CustomerException("You are not logged in with the id " + loggedInUserId);

		}
		throw new CustomerException("No customer present with the id " + loggedInUserId);

	}

	@Override
	public Product addRating(String productId, String loggedInUserId, Double rating)
			throws ProductException, CustomerException {
		// TODO Auto-generated method stub
          if(customerRepo.findById(loggedInUserId).get()!=null) {
        	  if (userSessionRepo.findById(loggedInUserId).get() != null) 
        	  {
        		  if(productRepo.findById(productId).get()!=null) 
        		  {
        			  Product p = productRepo.findById(productId).get();
        			  Double newRating = rating;
        			  Double prevRating = p.getRatings();
        			  Integer numOfRatings = p.getNumberOfRatings();
        			  p.setRatings((prevRating+newRating)/(numOfRatings+1));
        			  p.setNumberOfRatings((numOfRatings+1));
        			  return productRepo.save(p);
        		  }
        		  throw new ProductException("No product present with the id "+productId);
        	  }
        	  throw new CustomerException("You are not logged in with the id " + loggedInUserId);
          }
          throw new CustomerException("No customer present with the id " + loggedInUserId);
	}

	@Override
	public List<Product> sortProductsByPriceHighToLow(List<Product> products)
			throws ProductException{
		// TODO Auto-generated method stub
		Collections.sort(products, new HighToLowByPrice());
		if(products.size()==0) {
			throw new ProductException("Product list is empty");
		}
		return products;
	}

	@Override
	public List<Product> sortProductsByPriceLowToHigh(List<Product> products) throws ProductException {
		// TODO Auto-generated method stub
		Collections.sort(products, new LowToHighByPrice());
		if(products.size()==0) {
			throw new ProductException("Product list is empty");
		}
		return products;
	}

	@Override
	public List<Product> sortProductsByRatingsHighToLow(List<Product> products) throws ProductException {
		// TODO Auto-generated method stub
		Collections.sort(products, new HighToLowByRatings());
		if(products.size()==0) {
			throw new ProductException("Product list is empty");
		}
		return products;
	}

	@Override
	public List<Product> sortProductsByRatingsLowToHigh(List<Product> products) throws ProductException {
		// TODO Auto-generated method stub
		Collections.sort(products, new LowToHighByRatings());
		if(products.size()==0) {
			throw new ProductException("Product list is empty");
		}
		return products;
	}

	@Override
	public Product getProductDetailsById(String productId, String loggedInUserId) throws ProductException, CustomerException {
		// TODO Auto-generated method stub
		if(userSessionRepo.findById(loggedInUserId).get()!=null) {
			if(productRepo.findById(productId).get()!=null)
			{
				return productRepo.findById(productId).get();
			}
			throw new ProductException("No product present with the id "+productId);
		}
		throw new CustomerException("You are not logged in with the id "+loggedInUserId);
		
	}

	@Override
	public Product addToCart(String productId, String loggedInId, Integer quantity) throws ProductException, CustomerException {
		// TODO Auto-generated method stub
		if(userSessionRepo.findById(loggedInId).get()!=null) {
			if(productRepo.findById(productId).get()!=null)
			{
				
				User customer = customerRepo.findById(loggedInId).get();
				Product p = productRepo.findById(productId).get();
				List<Product> products = customer.getCart().getProducts();
				
				for(Product pro:products) {
					if(pro.getProductId() == p.getProductId()) {
						throw new ProductException("Product is already present in the cart");
					}
				}
				
				if(p.getQuantity()>quantity) {
					p.setQuantity(p.getQuantity()-quantity);
					productRepo.save(p);
					p.setQuantity(quantity);
					customer.getCart().getProducts().add(p);
					customerRepo.save(customer);
					return p;
				}
				throw new ProductException("only "+p.getQuantity()+" are left of "+p.getProductName());
				
			}
			throw new ProductException("No product present with the id "+productId);
		}
		throw new CustomerException("You are not logged in with the id "+loggedInId);
	}

}
