package com.capgemini.go.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cart_go_details")
public class CartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@SequenceGenerator(name = "cart_seq", sequenceName = "cart_seq", allocationSize = 1)
	private Integer cartId;

	// HAS - A relationship
	// One cart can have only one Customer.
	@OneToOne(mappedBy = "cart")
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private CustomerModel customer;

	// HAS - A relationship
	// One cart can have many products.
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="carts_products", joinColumns= {@JoinColumn(name="cartId")}, inverseJoinColumns = {@JoinColumn(name="productId")})
	private List<ProductModel> products;

	private Integer quantity;

	public CartModel(Integer cartId, List<ProductModel> products, Integer quantity) {
		super();
		this.cartId = cartId;
		this.products = products;
		this.quantity = quantity;
	}

}
