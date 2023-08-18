package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custDao;

	@Override
	public Customer addCustDetails(Customer cust) {
		return custDao.save(cust);
	}

	@Override
	public List<Customer> getAllCustomersDetails() {
		// TODO Auto-generated method stub
		return custDao.findAll();
	}

	@Override
	public Optional<Customer> getCustDetailsById(Long custId) {
		// TODO Auto-generated method stub
		return custDao.findById(custId);
	}

	@Override
	public void deleteCustomerDetails(Long custId) {
		// TODO Auto-generated method stub
		Customer cust = custDao.getById(custId);
		custDao.delete(cust);
	}

	
}
