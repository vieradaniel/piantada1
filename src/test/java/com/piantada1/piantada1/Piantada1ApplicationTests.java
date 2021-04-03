package com.piantada1.piantada1;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.piantada1.piantada1.model.Usuario;
import com.piantada1.piantada1.repo.UsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class Piantada1ApplicationTests {

	@Autowired
	private UsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void createUserTest() {
		
		Usuario user = new Usuario();
		user.setId(4L);
		user.setUsername("Robert");
		user.setPassword(encoder.encode("123456"));
		Usuario retorno = repo.save(user);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(user.getPassword()));
		
	}

}
