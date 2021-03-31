package com.piantada1.piantada1.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.piantada1.piantada1.model.PlushieItem;

@Repository
public interface PlushieItemRepo extends JpaRepository<PlushieItem, Long> {

	
	
}
