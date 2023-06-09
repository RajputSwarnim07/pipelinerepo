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
import javax.persistence.ManyToOne;
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
@Table(name = "product_go_details")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
	private Integer productId;
	private Double price;
	private String colour;
	private String dimension;
	private String brand;
	private Integer quantity;
	private String productCategory;
	private String productName;
	@ManyToMany(mappedBy = "products")
	@JsonIgnore
	private List<OrderModel> orders;
	@ManyToOne
	@JsonIgnore
	private WishlistModel wishlist;
	@ManyToMany(mappedBy = "products")
	@JsonIgnore
	private List<CartModel> cart;
}
