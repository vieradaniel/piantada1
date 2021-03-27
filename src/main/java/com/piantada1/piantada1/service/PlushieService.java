package com.piantada1.piantada1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piantada1.piantada1.model.Plushie;
import com.piantada1.piantada1.repo.PlushieRepo;



@Service
public class PlushieService {
	@Autowired
	private PlushieRepo repo;
	
	public List<Plushie> listAll(){
		return repo.findAll();
		
	}
	
	public Plushie listByName(String keyword){
		
		return repo.findByNameContains(keyword);
		
		
	}
	
	public void save(Plushie plushie) {
		repo.save(plushie);
	}
	
	public Optional<Plushie> get(Long id) {
		return repo.findById(id);
	}
	
	
	
	public void delete (Long id) {
		repo.deleteById(id);
	}
	
	
	
	
}
