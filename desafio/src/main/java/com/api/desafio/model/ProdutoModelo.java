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
@Table(name = "produto")
public class ProdutoModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduto")
	private int codigo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "vlcusto")
	private double vlCusto;
	@Column(name = "vlvenda")
	private double vlVenda;
	@ManyToOne
	@JoinColumn(name = "idcategoria")
	private CategoriaModelo categoria;
	
	
	public int getIdProduto() {
		return codigo;
	}
	public void setIdProduto(int idProduto) {
		this.codigo = idProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getVlCusto() {
		return vlCusto;
	}
	public void setVlCusto(double vlCusto) {
		this.vlCusto = vlCusto;
	}
	public double getVlVenda() {
		return vlVenda;
	}
	public void setVlVenda(double vlVenda) {
		this.vlVenda = vlVenda;
	}
	public CategoriaModelo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModelo categoria) {
		this.categoria = categoria;
	}
}
