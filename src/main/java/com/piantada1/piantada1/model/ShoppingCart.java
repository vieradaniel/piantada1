package com.piantada1.piantada1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart implements Serializable {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	
	@OneToMany(
			cascade = CascadeType.ALL, 
			orphanRemoval = true
	)
	@JoinColumn(name = "plushieitem_id")
	private List<PlushieItem> plushieItems;
	
	public ShoppingCart(List <PlushieItem> plushieItems) {
		this.plushieItems = plushieItems;
	}
	
	public boolean isEmpty() {
		return plushieItems.isEmpty();
	}
	
	public void removePlushieItem(PlushieItem plushieItem) {
		plushieItems.removeIf(item -> item.getId() == plushieItem.getId());
	}
	
	public void clearItems() {
		plushieItems.clear();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PlushieItem> getPlushieItems() {
		return plushieItems;
	}

	public void setPlushieItems(List<PlushieItem> plushieItems) {
		this.plushieItems = plushieItems;
	}
	
	public PlushieItem findPlushieItemByPlushie(Long id) {
		for (PlushieItem item: this.plushieItems) {
			if (item.getPlushie().getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
	
	
}
