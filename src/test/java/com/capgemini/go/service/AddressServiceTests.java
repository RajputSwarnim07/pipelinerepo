package com.capgemini.go.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.go.model.AddressModel;
import com.capgemini.go.repositories.AddressRepository;

@SpringBootTest
class AddressServiceTests {
	
	@Mock
	AddressRepository addRepo;
	
	@InjectMocks
	AddressServiceImpl addrSer;
	
	private AddressModel address;
	
	@BeforeEach
	void setup() {
		address = new AddressModel();
		address.setAddressId(1);
		address.setCity("Bengaluru");
	}
	
	@Test
	void testAddAddress() {
		
		when(addRepo.save(address)).thenReturn(address);
		
		AddressModel addr = addrSer.addAddress(address);
		
		assertEquals(addr, address);
	}
}
