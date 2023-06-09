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
@Table(name = "wishlist_go_details")
public class WishlistModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="wishlist_seq")
	@SequenceGenerator(name="wishlist_seq",sequenceName="wishlist_seq", allocationSize=1)
	private Integer wishlistId;
	
	// HAS - A relationship
	// One wishlist can have only one customer.
	@OneToOne(mappedBy = "wishlist")
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private CustomerModel customer;
	
	// HAS - A relationship
	// One wishlist can have many products.
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="wishList_products", joinColumns= {@JoinColumn(name="wishListId")}, inverseJoinColumns = {@JoinColumn(name="productId")})
	private List<ProductModel> products;
	
	private Integer quantity;
	
	public WishlistModel(Integer wishlistId, List<ProductModel> products, Integer quantity) {
		super();
		this.wishlistId = wishlistId;
		this.products = products;
		this.quantity = quantity;
	}
	
	
	
}
