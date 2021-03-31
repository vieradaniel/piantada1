package com.piantada1.piantada1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piantada1.piantada1.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);
	
}
