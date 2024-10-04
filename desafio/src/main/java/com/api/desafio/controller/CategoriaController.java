package com.api.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafio.model.CategoriaModelo;
import com.api.desafio.model.RespostaModelo;
import com.api.desafio.repository.CategoriaRepository;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	@Autowired
	private CategoriaRepository acoes;

	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public @ResponseBody List<CategoriaModelo> listar() {
		return acoes.findAll();
	}

	@RequestMapping(value = "/categorias", method = RequestMethod.POST)
	public @ResponseBody CategoriaModelo cadastrar(@RequestBody CategoriaModelo categoria) {
		return acoes.save(categoria);
	}

	@RequestMapping(value = "/categorias/{codigo}", method = RequestMethod.GET)
	public @ResponseBody CategoriaModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByIdCategoria(codigo);
	}

	@RequestMapping(value = "/categorias", method = RequestMethod.PUT)
	public @ResponseBody CategoriaModelo alterar(@RequestBody CategoriaModelo categoria) {
		return acoes.save(categoria);
	}

	@RequestMapping(value = "/categorias/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
		RespostaModelo resposta = new RespostaModelo();
		try {
			CategoriaModelo categoria = filtrar(codigo);
			acoes.delete(categoria);
			resposta.setMensagem("Categoria excluído com sucesso!");
		} catch (Exception e) {
			resposta.setMensagem("Falha ao remover: " + e.getMessage());
		}
		return resposta;
	}

}
