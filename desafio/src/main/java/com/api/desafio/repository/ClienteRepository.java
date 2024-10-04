package com.api.desafio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.desafio.model.ClienteModelo;

public interface ClienteRepository extends CrudRepository<ClienteModelo, Integer>{
	
	List<ClienteModelo> findAll();
	
	ClienteModelo findByIdCliente(int idcliente);
	
	void delete(ClienteModelo cliente);
	
	<ClienteMod extends ClienteModelo> ClienteMod save(ClienteMod cliente);

}
