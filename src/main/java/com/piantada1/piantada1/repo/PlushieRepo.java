package com.piantada1.piantada1.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.piantada1.piantada1.model.Plushie;

@Repository
public interface PlushieRepo extends JpaRepository<Plushie, Long> {
	
	

	public Plushie findByNameContains(String keyword);
	
}
