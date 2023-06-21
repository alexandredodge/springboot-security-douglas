package com.br.api.clientes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.api.clientes.entity.Cliente;
import com.br.api.clientes.model.repository.ClienteRepository;

@RestController
//@RequestMapping("/api/clientes")
public class ClienteController {

	private final ClienteRepository repository;
		
	@Autowired
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/buscas")
	public List<Cliente> buscarClientePorNome(@RequestParam("nome") String nome){
		return repository.findByNomeContaining(nome);
	}
		
	@GetMapping("{id}")
	public Cliente buscarPorId(@PathVariable Integer id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar( @PathVariable Integer id ) {
		repository.findById(id)
			.map( cliente -> {
				repository.delete(cliente);
				return Void.TYPE;
			} )
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
	
	
	@PostMapping
	@RequestMapping("/api/cadastrar")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(repository.save(cliente),HttpStatus.CREATED);
	} 
	
	@PutMapping
	@RequestMapping("/api/update/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id,@RequestBody Cliente clienteAtualizado) {
		repository.findById(id).map( cliente ->{
			clienteAtualizado.setId(cliente.getId());
			return repository.save(clienteAtualizado);
		} ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	

}
