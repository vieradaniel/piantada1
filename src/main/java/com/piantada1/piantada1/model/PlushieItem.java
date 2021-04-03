package com.piantada1.piantada1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "plushieitem")
public class PlushieItem implements Serializable {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@OneToOne          // is it already inferred? 
	@JoinColumn(name="plushie_id")
	private Plushie plushie;
	
	@ManyToOne
	@JoinColumn(name="users_id")
	private Usuario user;
	
	


	private Double price;
	private int ammount;
	
	
	public PlushieItem() {
		
	}

	public boolean canUpdateAmmount(Integer ammount) {
		return ammount == null || ammount <= 0 || this.getPlushie().hasStock(ammount);
	}
	
	public void addAmmount(int ammount) {
		if (ammount > 0) {
			this.ammount= this.ammount + ammount;
		}
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Plushie getPlushie() {
		return plushie;
	}


	public void setPlushie(Plushie plushie) {
		this.plushie = plushie;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getAmmount() {
		return ammount;
	}


	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}



	public Usuario getUsuario() {
		return user;
	}



	public void setUsuario(Usuario user) {
		this.user = user;
	}
	
	
	
	
}




