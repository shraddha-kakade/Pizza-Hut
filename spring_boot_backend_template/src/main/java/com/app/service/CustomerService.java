package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.Customer;

public interface CustomerService {
	Customer addCustDetails(Customer cust);
	List<Customer> getAllCustomersDetails();
	Optional<Customer> getCustDetailsById(Long custId);
	void deleteCustomerDetails(Long custId);
}
