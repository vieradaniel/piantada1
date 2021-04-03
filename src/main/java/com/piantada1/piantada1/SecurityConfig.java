package com.piantada1.piantada1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.piantada1.piantada1.service.UsuarioService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception{
			auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/index.html").permitAll()
		.antMatchers("/catalogo").authenticated()
		.antMatchers("/admin/**").authenticated()
		.antMatchers("/new").authenticated()
		.antMatchers("/admin/index").hasRole("ADMIN")
		.antMatchers("/management/index").hasAnyRole("ADMIN","MANAGER")
		.and()
		//.logout().logoutRequestMatcher(new AntPathRequestMatcher("logout")).logoutSuccessUrl("/")
		.httpBasic()
		;
	}

}
