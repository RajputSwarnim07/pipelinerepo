package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.CartModel;

public interface CartRepository extends CrudRepository<CartModel, Integer>{

}
