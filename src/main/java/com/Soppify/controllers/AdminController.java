package com.Soppify.Controllers;

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

import com.Soppify.Entity.Admin;
import com.Soppify.Entity.AdminDto;
import com.Soppify.Entity.Category;
import com.Soppify.Entity.Product;
import com.Soppify.Exceptions.AdminException;
import com.Soppify.Exceptions.CategoryException;
import com.Soppify.Exceptions.ProductException;
import com.Soppify.Repositories.AdminRepo;
import com.Soppify.Services_Impl.AdminService;

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
