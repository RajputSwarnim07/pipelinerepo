package com.capgemini.go.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user_go_details")
public class UserModel {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq",sequenceName="user_seq", allocationSize=1)
	private Integer userId;
	@NotBlank(message="UserName is a required field")
	@Column(unique = true)
	private String userName;
	private String userType;
	@NotBlank(message="Password is a required field")
	private String userPassword;
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	@Exclude
	private CustomerModel customer;
	
	public UserModel(String userName, Integer userId, String userType, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}

	public UserModel(@NotBlank(message = "UserName is a required field") String userName,
			@NotBlank(message = "Password is a required field") String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	
	
}