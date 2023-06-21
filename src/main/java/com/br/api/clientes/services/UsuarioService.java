package com.br.api.clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.api.clientes.entity.Usuario;
import com.br.api.clientes.model.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
		return User
					.builder()
					.username(usuario.getUsername())
					.password(usuario.getPassword())
					.roles("USER").build();
	}

}
