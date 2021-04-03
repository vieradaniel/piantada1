package com.piantada1.piantada1.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.piantada1.piantada1.model.PlushieItem;
import com.piantada1.piantada1.model.Usuario;

@Repository
public interface PlushieItemRepo extends JpaRepository<PlushieItem, Long> {

	List <PlushieItem> findAllByUser(Usuario user);
	
	void deleteAllByUser (Usuario user);
	
}
