package com.Soppify.controllers;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Soppify.exceptions.AdminException;
import com.Soppify.exceptions.CategoryException;
import com.Soppify.exceptions.ProductException;
import com.Soppify.models.Admin;
import com.Soppify.models.AdminDto;
import com.Soppify.models.Category;
import com.Soppify.models.Product;
import com.Soppify.repositories.AdminRepo;
import com.Soppify.services.AdminService;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
	private AdminRepo adminRepo;
    
    @Autowired
    private AdminService adminService;
	
    @PostMapping("/admin/{loggedInAdminId}")
	public ResponseEntity<AdminDto> insertAdmin(@Valid @RequestBody Admin admin, @PathVariable("loggedInAdminId") String adminId) throws AdminException {
    	return new ResponseEntity<AdminDto>(adminService.insertAdmin(admin, adminId), HttpStatus.OK);
	}
 
    
    @PostMapping("category/{loggedInAdminId}")
    public ResponseEntity<Category> insertCategory(@Valid @RequestBody Category category, @PathVariable("loggedInAdminId") String adminId) throws AdminException, CategoryException{
    	return new ResponseEntity<Category>(adminService.insertCategory(category, adminId), HttpStatus.OK);
    }
    
    
    @PostMapping("/product/{loggedInAdminId}")
    public ResponseEntity<Product> insertProduct(@Valid @RequestBody Product product, @PathVariable("loggedInAdminId") String adminId, @RequestParam(value = "categoryName") String name) throws AdminException, ProductException, CategoryException{
    	
    	return new ResponseEntity<Product>(adminService.insertProduct(product, name, adminId), HttpStatus.OK);
    	
    }
    
    
    @GetMapping("/msg")
	public String message() {
	
		return "Saved successfully";
	}
}
