package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.model.CartModel;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.service.CartService;

@RestController
@CrossOrigin
public class CartController {

	@Autowired
	CartService cartSer;
	
	/**
	 * http://localhost:8080/viewcart/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("/viewcart/{id}")
	public CartModel viewCart(@PathVariable("id") Integer id) {
		return cartSer.viewCartById(id);
	}
	
	/**
	 *  http://localhost:8080/addproducttocart/{cartid}/{prodid}
	 * @param cartId
	 * @param prodId
	 * @return
	 * @throws ProductNotFoundException
	 */
	@PostMapping("/addproducttocart/{cartid}/{prodid}")
	public List<ProductModel> addProdToCart(@PathVariable("cartid") Integer cartId, @PathVariable("prodid") Integer prodId) throws ProductNotFoundException {
		return cartSer.addProductToCart(cartId, prodId);
	}
	
	/**
	 *  http://localhost:8080/addproducttocart/{cartid}/{prodid}
	 * @param cartId
	 * @param prodId
	 * @return
	 * @throws ProductNotFoundException
	 */
	@PostMapping("/deleteproductfromcart/{cartid}/{prodid}")
	public List<ProductModel> deleteProdFromCart(@PathVariable("cartid") Integer cartId, @PathVariable("prodid") Integer prodId) throws ProductNotFoundException {
		return cartSer.deleteProductFromCart(cartId, prodId);
	}
	
	// http://localhost:8080/getcartproducts/{cartid}
	@GetMapping("/getcartproducts/{cartid}")
	public List<ProductModel> getCartProducts(@PathVariable("cartid") Integer cartId) {
		return cartSer.getAllCartProducts(cartId);
	}
}
