package com.Soppify.Services_Impl;

import com.Soppify.DTO.CustomerDto;
import com.Soppify.Entity.AdminCurrentSession;
import com.Soppify.Entity.AdminDto;
import com.Soppify.Entity.CustomerCurrentSession;
import com.Soppify.Entity.User;
import com.Soppify.Exceptions.AdminException;
import com.Soppify.Exceptions.CustomerException;

public interface LoginService {

	public AdminCurrentSession adminLogin (AdminDto adminDto) throws AdminException;
	
	public CustomerDto customerRegister(User customer) throws CustomerException;
	
	public CustomerCurrentSession customerLogin(CustomerDto customerDto) throws CustomerException;
	
}
