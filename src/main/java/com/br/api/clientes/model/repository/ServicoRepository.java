package com.br.api.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.clientes.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico,Integer>{

}
