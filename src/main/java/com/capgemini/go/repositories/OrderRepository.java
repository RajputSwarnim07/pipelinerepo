package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.OrderModel;

public interface OrderRepository extends CrudRepository<OrderModel, Integer>{

}
