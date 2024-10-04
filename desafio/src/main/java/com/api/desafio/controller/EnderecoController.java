package com.api.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafio.model.EnderecoModelo;
import com.api.desafio.model.RespostaModelo;
import com.api.desafio.repository.EnderecoRepository;

@RestController
@RequestMapping("/api")
public class EnderecoController {
	@Autowired
	private EnderecoRepository acoes;

	@RequestMapping(value = "/enderecos", method = RequestMethod.GET)
	public @ResponseBody List<EnderecoModelo> listar() {
		return acoes.findAll();
	}

	@RequestMapping(value = "/enderecos", method = RequestMethod.POST)
	public @ResponseBody EnderecoModelo cadastrar(@RequestBody EnderecoModelo endereco) {
		return acoes.save(endereco);
	}

	@RequestMapping(value = "/enderecos/{codigo}", method = RequestMethod.GET)
	public @ResponseBody EnderecoModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByIdEndereco(codigo);
	}

	@RequestMapping(value = "/enderecos", method = RequestMethod.PUT)
	public @ResponseBody EnderecoModelo alterar(@RequestBody EnderecoModelo endereco) {
		return acoes.save(endereco);
	}

	@RequestMapping(value = "/enderecos/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
		RespostaModelo resposta = new RespostaModelo();
		try {
			EnderecoModelo endereco = filtrar(codigo);
			acoes.delete(endereco);
			resposta.setMensagem("Endereco excluído com sucesso!");
		} catch (Exception e) {
			resposta.setMensagem("Falha ao remover: " + e.getMessage());
		}
		return resposta;
	}

}
