package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantidade;
	@ManyToOne
	private Produto produto;
	private double subTotal;

	public Item() {
		super();
	}
	
	public boolean possuiEstoque() {
		return (this.produto.getEstoque() - this.quantidade) < 0 ? false : true;
	}
	
	public void atualizarEstoque() {
		this.produto.diminuirEstoque(getQuantidade());
	}
	
	public void atualizarQuantidade(int quantidade) {
		this.quantidade += quantidade;
		this.setSubTotal();
//		this.produto.diminuirEstoque(quantidade);
	}
	
	public void reporEstoque() {
		this.produto.aumentarEstoque(this.quantidade);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		setSubTotal();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public void setSubTotal() {
		this.setSubTotal(this.getQuantidade() * (this.getProduto().getPreco())); 
	}

	public boolean isMesmoProduto(Object obj) {
		Item item = (Item) obj;
		if(item.getProduto().equals(this.getProduto())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return produto.getNome() + "\t" + quantidade + " x " + produto.getPreco()
				+ " = " + subTotal + "\n";
	}
	
}
