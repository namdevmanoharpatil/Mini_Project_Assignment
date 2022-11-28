package com.Soppify.services;

import com.Soppify.DTO.CustomerDto;
import com.Soppify.exceptions.AdminException;
import com.Soppify.exceptions.CustomerException;
import com.Soppify.models.AdminCurrentSession;
import com.Soppify.models.AdminDto;
import com.Soppify.models.CustomerCurrentSession;
import com.Soppify.models.User;

public interface LoginService {

	public AdminCurrentSession adminLogin (AdminDto adminDto) throws AdminException;
	
	public CustomerDto customerRegister(User customer) throws CustomerException;
	
	public CustomerCurrentSession customerLogin(CustomerDto customerDto) throws CustomerException;
	
}
