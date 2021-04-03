package com.piantada1.piantada1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.piantada1.piantada1.model.Plushie;
import com.piantada1.piantada1.model.PlushieItem;
import com.piantada1.piantada1.model.ShoppingCart;
import com.piantada1.piantada1.model.Usuario;
import com.piantada1.piantada1.repo.PlushieItemRepo;

@Service
public class ShoppingCartService {
	
	@Autowired
	private PlushieItemRepo plushieItemRepo;

	public ShoppingCart getShoppingCart(Usuario user) {
		return new ShoppingCart(plushieItemRepo.findAllByUser(user));
	}
	
	public PlushieItem findPlushieItemById(Long plushieItemId) {
		Optional<PlushieItem> opt = plushieItemRepo.findById(plushieItemId);
		return opt.get();
	}
	
	
	public PlushieItem addPlushieToShoppingCart(Plushie plushie, Usuario user, int ammount) {
		
		ShoppingCart shoppingCart = this.getShoppingCart(user);
		PlushieItem plushieItem = shoppingCart.findPlushieItemByPlushie(plushie.getId());
		
		if(plushieItem != null) {
			plushieItem.addAmmount(ammount);
			plushieItem = plushieItemRepo.save(plushieItem);
		}else {
			plushieItem= new PlushieItem();
			plushieItem.setUsuario(user);
			plushieItem.setPlushie(plushie);
			plushieItem.setAmmount(ammount);
			plushieItem = plushieItemRepo.save(plushieItem);
		}
		return plushieItem;
		
	}
	
	public void removePlushieItem(PlushieItem plushieItem) {
		plushieItemRepo.deleteById(plushieItem.getId());
	}
	
	public void updatePlushieItem(PlushieItem plushieItem , Integer ammount) {
		if(ammount == null || ammount <=0) {
			this.removePlushieItem(plushieItem);
		}else if (plushieItem.getPlushie().hasStock(ammount)) {
			plushieItem.setAmmount(ammount);
			plushieItemRepo.save(plushieItem);
		}
	}
	
	public void clearShoppingCart(Usuario user) {
		plushieItemRepo.deleteAllByUser(user);
	}
	
	
	
	
	
}
