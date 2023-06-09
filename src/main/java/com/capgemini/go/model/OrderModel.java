package com.capgemini.go.model;

import java.time.LocalDate;
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
@Table(name = "order_go_details")
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")
	@SequenceGenerator(name="order_seq",sequenceName="order_seq", allocationSize=1)
	private Integer orderId;
	
	// HAS - A relationship
	// A customer can have many orders. But one order can be ordered by only one customer.
	@ManyToOne(cascade = CascadeType.ALL) //Owning side
	@JoinColumn(name="cust_id")
	@JsonIgnore
	private CustomerModel customer;
	
	// HAS - MANY relationship
	// An order can have many products and one product can belong to many orders.
	@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE} )
	@JoinTable(name = "go_product_orders", joinColumns = { @JoinColumn(name = "orderId") }, inverseJoinColumns = {
			@JoinColumn(name = "productId") })
//	@Cascade(CascadeType.SAVE_UPDATE)
//	@JsonIgnore
	private List<ProductModel> products;
	
	private Integer totalQuantity;
	private Double totalPrice;
	private LocalDate orderDeliveryDate;
	private LocalDate orderDispatchDate;

}
