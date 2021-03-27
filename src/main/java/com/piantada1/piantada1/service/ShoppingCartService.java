package com.piantada1.piantada1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piantada1.piantada1.model.Customer;
import com.piantada1.piantada1.model.PlushieItem;
import com.piantada1.piantada1.repo.PlushieItemRepo;

@Service
public class ShoppingCartService {
	
	@Autowired
	private PlushieItemRepo cartRepo;
	
	public List<PlushieItem> listPlushieItems(Customer customer){
		return cartRepo.findByCustomer(customer);
	}
	

}
