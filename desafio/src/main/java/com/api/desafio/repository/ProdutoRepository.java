package com.api.desafio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.desafio.model.ProdutoModelo;

public interface ProdutoRepository extends CrudRepository<ProdutoModelo, Integer>{
	
	List<ProdutoModelo> findAll();
	
	ProdutoModelo findByCodigo(int codigo);
	
	void delete(ProdutoModelo produto);
	
	<ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);

}
