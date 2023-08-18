package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
