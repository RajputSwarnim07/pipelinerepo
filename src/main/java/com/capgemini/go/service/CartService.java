package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.model.CartModel;
import com.capgemini.go.model.ProductModel;

public interface CartService {
	
	public CartModel viewCartById(Integer id);
	
	public List<ProductModel> addProductToCart(Integer cartId, Integer productId) throws ProductNotFoundException;
	
	public List<ProductModel> deleteProductFromCart(Integer cartId, Integer productId) throws ProductNotFoundException;
	
	public List<ProductModel> getAllCartProducts(Integer cartId);
}
