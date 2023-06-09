package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.AddressModel;

public interface AddressRepository extends CrudRepository<AddressModel, Integer>{

}
