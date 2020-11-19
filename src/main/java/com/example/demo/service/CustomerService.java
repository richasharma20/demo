package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		
		List<Customer> customer = new ArrayList<>();
		customerRepository.findAll().forEach(customer1 -> customer.add(customer1));
		// TODO Auto-generated method stub
		return customer;
	}

	public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId).get();
	}

	public void saveOrUpdate(Customer customer) {
		customerRepository.save(customer);
		// TODO Auto-generated method stub
		
	}

}
