package com.api.desafio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.desafio.model.CategoriaModelo;

public interface CategoriaRepository extends CrudRepository<CategoriaModelo, Integer>{
	
	List<CategoriaModelo> findAll();
	
	CategoriaModelo findByIdCategoria(int idcategoria);
	
	void delete(CategoriaModelo categoria);
	
	<CatMod extends CategoriaModelo> CatMod save(CatMod categoria);

}
