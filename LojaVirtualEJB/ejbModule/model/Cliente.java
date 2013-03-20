package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Usuario {
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
	private List<Venda> vendas;

	public Cliente() {
		super();
		vendas = new ArrayList<Venda>();
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public void addVenda(Venda venda) {
		this.vendas.add(venda);
	}
	
	public void removerVenda(Venda venda) {
		this.vendas.remove(venda);
	}

	@Override
	public String toString() {
		return super.toString() + "Permissão: Cliente\nTotal de vendas efetuadas: "+ vendas.size() +"\n";
	}
	
	

}
