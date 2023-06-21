package com.br.api.clientes.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.clientes.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

	Optional<Usuario> findByUsername(String username);
}
