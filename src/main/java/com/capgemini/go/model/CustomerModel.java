package com.capgemini.go.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
@Table(name = "customer_go_details")
public class CustomerModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cust_seq")
	@SequenceGenerator(name="cust_seq",sequenceName="cust_seq", allocationSize=1)
	private Integer customerId;
	
	@NotBlank(message="Name is a required field")
	private String customerName;
	
	@NotBlank(message="Mobile No is a required field")
	@Pattern(regexp="\\d{10}")
	@Column(unique = true)
	private String mobileNo;
	
	@NotBlank(message="Email is a required field")
	@Email
	private String email;
	
	// HAS - A relationship
	// One customer can have only one Address.
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="address_id")
	private AddressModel address;
	
	//IS - A relationship
	// Customer is a sub-class of User.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_Id")
	private UserModel user;
	
	// HAS - A relationship
	// Customer has one Cart
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private CartModel cart;
	
	// HAS - A relationship
	// Customer has one wishlist
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="wishlist_id")
	private WishlistModel wishlist;
	
	// One Customer can have many Orders
	@OneToMany(mappedBy = "customer")
	private List<OrderModel> orders;
	
	
	
}
