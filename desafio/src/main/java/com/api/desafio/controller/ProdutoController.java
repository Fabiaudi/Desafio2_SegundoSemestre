package com.api.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafio.model.ProdutoModelo;
import com.api.desafio.model.RespostaModelo;
import com.api.desafio.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	@Autowired
	private ProdutoRepository acoes;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listar(){
		return acoes.findAll();
	}
	
	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto){
		return acoes.save(produto);
	}
	
	@RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo){
		return acoes.findByCodigo(codigo);
	}
	
	@RequestMapping(value = "/produtos", method = RequestMethod.PUT)
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto){
		return acoes.save(produto);
	}
	
	@RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo){
		RespostaModelo resposta = new RespostaModelo();
		try {
			ProdutoModelo produto = filtrar(codigo);
			acoes.delete(produto);
			resposta.setMensagem("Produto excluído com sucesso!");
		} catch(Exception e) {
			resposta.setMensagem("Falha ao remover: " + e.getMessage());
		}
		return resposta;
	}
	
}
