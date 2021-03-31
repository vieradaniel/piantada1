package com.piantada1.piantada1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.piantada1.piantada1.model.Usuario;
import com.piantada1.piantada1.repo.UsuarioRepo;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usuario user = repo.findByUsername(username);
			
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("ADMIN"));
		
			UserDetails userDet = new User(user.getUsername(),user.getPassword(),roles);
			
			return userDet;
	}

}
