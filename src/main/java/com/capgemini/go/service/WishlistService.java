package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.exception.ProductAlreadyExistsException;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;

public interface WishlistService {
	
	public WishlistModel viewWishlist(Integer id);
	
	public List<ProductModel> addProductToWishlist(Integer prodId, Integer wishId) throws ProductNotFoundException, ProductAlreadyExistsException;
	
	public List<ProductModel> deleteProductFromWishlist(Integer prodId, Integer wishlistId) throws ProductNotFoundException;

	public List<ProductModel> getAllWishProducts(Integer wishId);
}
