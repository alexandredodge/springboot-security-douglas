package com.br.api.clientes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.api.clientes.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

	@Query("SELECT p FROM Cliente p WHERE p.nome LIKE %:nome%")
	List<Cliente> findByNomeContaining(@Param("nome") String nome);
}
