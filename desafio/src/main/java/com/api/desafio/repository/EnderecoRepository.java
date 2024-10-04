package com.api.desafio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.desafio.model.EnderecoModelo;

public interface EnderecoRepository extends CrudRepository<EnderecoModelo, Integer>{
	
	List<EnderecoModelo> findAll();
	
	EnderecoModelo findByIdEndereco(int idendereco);
	
	void delete(EnderecoModelo endereco);
	
	<EndMod extends EnderecoModelo> EndMod save(EndMod endereco);
}
