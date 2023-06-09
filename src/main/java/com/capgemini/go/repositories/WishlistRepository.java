package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.WishlistModel;

public interface WishlistRepository extends CrudRepository<WishlistModel, Integer>{

}
