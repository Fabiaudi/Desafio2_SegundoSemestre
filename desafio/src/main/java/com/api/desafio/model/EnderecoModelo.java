package com.api.desafio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class EnderecoModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idendereco")
	private int idEndereco;
	@Column(name = "rua")
	private String rua;	
	@Column(name = "bairro")
	private String bairro;	
	@Column(name = "cidade")
	private String cidade;	
	@Column(name = "uf")
	private String uf;	
	@Column(name = "cep")
	private String cep;	
	@ManyToOne
    @JoinColumn(name = "idcliente")
    private ClienteModelo cliente;
	
	public ClienteModelo getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModelo cliente) {
		this.cliente = cliente;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getRua() {
		return rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
	
}
