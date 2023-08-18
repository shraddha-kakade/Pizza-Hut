package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	public CustomerController() {
		//super();
		System.out.println("controller const");
	}

	@Autowired
	private CustomerService custService;
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer cust)
	{
		return custService.addCustDetails(cust);
	}
	
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		return custService.getAllCustomersDetails();
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer cust)
	{
		custService.getCustDetailsById(cust.getCustId());
		return custService.addCustDetails(cust);
	}
	
	@DeleteMapping("/{custId}")
	public void deleteCustomer(@PathVariable Long custId)
	{
		custService.deleteCustomerDetails(custId);
	}
}
