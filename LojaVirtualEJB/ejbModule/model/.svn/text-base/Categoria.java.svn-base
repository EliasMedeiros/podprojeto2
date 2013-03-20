package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="categoria")
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		this.produtos.remove(produto);
	}

	@Override
	public String toString() {
		return "Categoria\n" + id + " - " + nome + "\nQuantidade de Produtos: "
				+ produtos.size() + "\n";
	}
	

}
