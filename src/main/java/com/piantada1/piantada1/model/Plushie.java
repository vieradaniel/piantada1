package com.piantada1.piantada1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



	@Entity
	public class Plushie implements Serializable{
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Id
		private Long id;	
		@Column(name="name", length = 50)
		private String name;
				
		//private List<Category> categories;

		private Double price;
		
		/*
		@OneToMany(mappedBy="plushie", cascade=CascadeType.ALL,orphanRemoval=true)
		private Set<Category> categories; // this can be a class*/
		
		
		private int stock;
		
			
		public Plushie() {
			// TODO Auto-generated constructor stub
		}


		
		public boolean hasStock(int amount) {
			return (this.getStock() > 0) && (amount <=this.getStock());
		}
		
		public void decreaseStock(int amount) {
			this.stock -= amount;
		}
		
		
		public Integer getStock() {
			return stock;
		}




		public void setStock(Integer stock) {
			this.stock = stock;
		}




		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		
/*
		public Set<Category> getCategories() {
			return categories;
		}


		public void setCategories(Set<Category> categories) {
			this.categories = categories;
		}

*/
		
		
		
		
	
}

