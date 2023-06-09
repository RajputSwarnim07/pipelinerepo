package com.capgemini.go.service;

import com.capgemini.go.exception.AddressNotFoundException;
import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.model.AddressModel;
import com.capgemini.go.model.CustomerModel;

public interface AddressService {
	
	public AddressModel addAddress(AddressModel address);
	
	public AddressModel updateAddress(AddressModel address) throws AddressNotFoundException;
	
	public String deleteAddressById(Integer addressId)  throws AddressNotFoundException;
	
	public AddressModel getAddressById(Integer id) throws AddressNotFoundException;
	
	public CustomerModel getCustomerByAddressId(Integer id) throws CustomerNotFoundException;
}
