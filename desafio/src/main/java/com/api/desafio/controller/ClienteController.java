package com.api.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafio.model.ClienteModelo;
import com.api.desafio.model.EnderecoModelo;
import com.api.desafio.model.RespostaModelo;
import com.api.desafio.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	private ClienteRepository acoes;
	@Autowired
	private EnderecoController enderecoController; 


	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public @ResponseBody List<ClienteModelo> listar() {
		return acoes.findAll();
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
	public @ResponseBody ClienteModelo cadastrar(@RequestBody ClienteModelo cliente) {
        ClienteModelo clienteSalvo = acoes.save(cliente);
        
        for (EnderecoModelo clienteEndereco : cliente.getEnderecos()) {        	
        	clienteEndereco.setCliente(clienteSalvo);
        	EnderecoModelo enderecoSalvo = enderecoController.cadastrar(clienteEndereco);

            clienteEndereco.setRua(enderecoSalvo.getRua());            
        }
		
		
		return clienteSalvo;
	}


	@RequestMapping(value = "/clientes/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ClienteModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByIdCliente(codigo);
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.PUT)
	public @ResponseBody ClienteModelo alterar(@RequestBody ClienteModelo cliente) {
		return acoes.save(cliente);
	}

	@RequestMapping(value = "/clientes/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
		RespostaModelo resposta = new RespostaModelo();
		try {
			ClienteModelo cliente = filtrar(codigo);
			acoes.delete(cliente);
			resposta.setMensagem("Cliente excluído com sucesso!");
		} catch (Exception e) {
			resposta.setMensagem("Falha ao remover: " + e.getMessage());
		}
		return resposta;
	}

}
