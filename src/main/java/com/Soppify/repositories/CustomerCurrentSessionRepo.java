package com.Soppify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soppify.models.CustomerCurrentSession;

public interface CustomerCurrentSessionRepo extends JpaRepository<CustomerCurrentSession, String>{

}
