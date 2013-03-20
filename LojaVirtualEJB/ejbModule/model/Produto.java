package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(name="descricao")
	private String descrição;
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Categoria categoria;
	private int estoque;
	private double preco;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Marca marca;
	private String imagem;
//	private boolean destaque;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<Item> items;
	private int quantidadeVendida;

	public Produto() {
		super();
		items = new ArrayList<Item>();
		setImagem("produto.jpg");
	}
	
	public void diminuirEstoque(int quantidade) {
		this.estoque -= quantidade;
	}
	
	public void aumentarEstoque(int quantidade) {
		this.estoque += quantidade;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public double getPreco() {
		return preco;
	}

	public String getPrecoFormatado() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		return formatador.format(preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getImagem() {
		if(imagem == null || imagem == "") {
			return "produto.jpg";
		}
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

//	public boolean isDestaque() {
//		return destaque;
//	}
//
//	public void setDestaque(boolean destaque) {
//		this.destaque = destaque;
//	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		setQuantidadeVendida(atualizarQuantidadeVendida());
	}
	
	public void adicionarItem(Item item) {
		this.items.add(item);
		setQuantidadeVendida(atualizarQuantidadeVendida());
	}
	
	public void removerItem(Item item) {
		this.items.remove(item);
		setQuantidadeVendida(atualizarQuantidadeVendida());
	}
	
	public int atualizarQuantidadeVendida() {
		int quantidadeVendida = 0;
		for(Item item : this.items) {
			quantidadeVendida += item.getQuantidade();
		}
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	@Override
	public String toString() {
		String dados = "Produto " + id;
		dados += "\nNome: " + nome;
		dados += "\nDescrição: " + descrição;
		dados += "\nCategoria: "+ categoria.getNome();
		dados += "\nQuantidade em Estoque: "+ estoque;
		dados += "\nPreço: "+ preco;
		dados += "\nMarca: "+ marca.getNome();
		dados += "\nQuantidade Vendidos: "+ items.size();
		return dados;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descrição == null) {
			if (other.descrição != null)
				return false;
		} else if (!descrição.equals(other.descrição))
			return false;
		if (estoque != other.estoque)
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	

}
