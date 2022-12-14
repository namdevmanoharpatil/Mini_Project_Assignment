package com.Soppify.Services_Impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Soppify.DTO.CustomerDto;
import com.Soppify.Entity.Admin;
import com.Soppify.Entity.AdminCurrentSession;
import com.Soppify.Entity.AdminDto;
import com.Soppify.Entity.Cart;
import com.Soppify.Entity.CustomerCurrentSession;
import com.Soppify.Entity.User;
import com.Soppify.Exceptions.AdminException;
import com.Soppify.Exceptions.CustomerException;
import com.Soppify.Repositories.AdminCurrentSessionRepo;
import com.Soppify.Repositories.AdminRepo;
import com.Soppify.Repositories.CustomerCurrentSessionRepo;
import com.Soppify.Repositories.CustomerRepo;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AdminCurrentSessionRepo adminCurrentSession;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private CustomerCurrentSessionRepo customerCurrentSessionRepo;
	
	@Override
	public AdminCurrentSession adminLogin(AdminDto admin) throws AdminException {
		// TODO Auto-generated method stub
		
Admin a = adminRepo.findByUsername(admin.getUsername());
		
		if(a!=null) {
			
			
			if(a.getPassword().equals(admin.getPassword())) {
				
				AdminCurrentSession acs =  adminCurrentSession.findByUsername(a.getUsername());
				if(acs == null) {
					AdminCurrentSession ac = new AdminCurrentSession(a.getAdminId(), a.getUsername(), RandomString.make(6), LocalDateTime.now());
					
					adminCurrentSession.save(ac);
					
					return ac;
				}
				
				throw new AdminException("Admin is already logged in");
			}else {
				throw new AdminException("Incorrect Password");
			}
			
		}
		throw new AdminException("No admin available with the username "+admin.getUsername());
		
	}

	
	
	public CustomerDto customerRegister(User customer) throws CustomerException {
		
		User u = customerRepo.findByUsername(customer.getUsername());
		if(u==null)
		{
			customer.setUserId("cu"+"_"+RandomString.make(10));
			Cart c = new Cart(customer);
			customer.setCart(c);
			customerRepo.save(customer);
			CustomerDto cdto = new CustomerDto(customer.getUserId(), customer.getUsername(), customer.getPassword());
			return cdto;
		}
		throw new CustomerException("Custommer Already exists with the username "+customer.getUsername());
	}



	


	@Override
	public CustomerCurrentSession customerLogin(CustomerDto customerDto) throws CustomerException {
		// TODO Auto-generated method stub
		
		Optional<User> customerOptional = customerRepo.findById(customerDto.getId());
		User customer = customerOptional.get();
		if(customerOptional.get()!=null)
		{
			if(customer.getUsername().equals(customerDto.getUsername()))
			{
				if(customer.getPassword().equals(customerDto.getPassword()))
				{
					CustomerCurrentSession ccs = new CustomerCurrentSession(customerDto.getId(), customerDto.getUsername(), customerDto.getPassword(), LocalDateTime.now());
					return customerCurrentSessionRepo.save(ccs);
				}
				throw new CustomerException("Password is not correct!");
			}
			throw new CustomerException("Username is not correct!");
		}
		throw new CustomerException("No customer present with the id "+customerDto.getId());
	}
}
