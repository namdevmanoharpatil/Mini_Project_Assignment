package com.Soppify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.Entity.CustomerCurrentSession;

public interface CustomerCurrentSessionRepo extends JpaRepository<CustomerCurrentSession, String>{

}
