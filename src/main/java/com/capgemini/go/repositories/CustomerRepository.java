package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.CustomerModel;

public interface CustomerRepository extends CrudRepository<CustomerModel, Integer>{

	public CustomerModel findByMobileNo(String mobileNo);
}
