package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/customers")
	private List<Customer> getAllCustomers() 
	{
	return customerService.getAllCustomers();
	}
	//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/customers/{customerId}")
	private Customer getCustomer(@PathVariable("customerId") int customerId) 
	{
	return customerService.getCustomerById(customerId);
	}
	
	//creating post mapping that post the book detail in the database
	@PostMapping("/customers")
	private int saveCustomer(@RequestBody Customer customer) 
	{
	customerService.saveOrUpdate(customer);
	return customer.getCustomerId();
	}
	//creating put mapping that updates the book detail 
	@PutMapping("/customers")
	private Customer update(@RequestBody Customer customer) 
	{
	customerService.saveOrUpdate(customer);
	return customer;
	}
}
