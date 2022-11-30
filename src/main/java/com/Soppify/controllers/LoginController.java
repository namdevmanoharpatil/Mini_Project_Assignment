package com.Soppify.Controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Soppify.DTO.CustomerDto;
import com.Soppify.Entity.Admin;
import com.Soppify.Entity.AdminCurrentSession;
import com.Soppify.Entity.AdminDto;
import com.Soppify.Entity.CustomerCurrentSession;
import com.Soppify.Entity.User;
import com.Soppify.Exceptions.AdminException;
import com.Soppify.Exceptions.CustomerException;
import com.Soppify.Repositories.AdminCurrentSessionRepo;
import com.Soppify.Repositories.AdminRepo;
import com.Soppify.Services_Impl.LoginService;
import com.Soppify.Services_Impl.LoginServiceImpl;

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
