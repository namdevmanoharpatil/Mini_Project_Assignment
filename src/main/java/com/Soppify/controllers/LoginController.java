package com.Soppify.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Soppify.DTO.CustomerDto;
import com.Soppify.exceptions.AdminException;
import com.Soppify.exceptions.CustomerException;
import com.Soppify.models.Admin;
import com.Soppify.models.AdminCurrentSession;
import com.Soppify.models.AdminDto;
import com.Soppify.models.CustomerCurrentSession;
import com.Soppify.models.User;
import com.Soppify.repositories.AdminCurrentSessionRepo;
import com.Soppify.repositories.AdminRepo;
import com.Soppify.services.LoginService;
import com.Soppify.services.LoginServiceImpl;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/admin")
	public ResponseEntity<AdminCurrentSession> adminLogin( @RequestBody AdminDto admin) throws AdminException {
		return new ResponseEntity<AdminCurrentSession>(loginService.adminLogin(admin), HttpStatus.OK);
	}
	
	
	@PostMapping("/customer/register")
	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody User customer) throws CustomerException{
		return new ResponseEntity<CustomerDto>(loginService.customerRegister(customer), HttpStatus.OK);
	}
	
	
	@PostMapping("/customer/login")
	public ResponseEntity<CustomerCurrentSession> loginCustomer(@RequestBody CustomerDto customerDto) throws CustomerException{
		return new ResponseEntity<CustomerCurrentSession>(loginService.customerLogin(customerDto), HttpStatus.OK);
	}
	
}
