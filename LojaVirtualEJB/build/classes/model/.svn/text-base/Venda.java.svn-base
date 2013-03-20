package model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import projeto.exception.EstoqueInsuficienteException;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items;
	private double valorTotal;
	@ManyToOne
	private Cliente cliente;
	@Temporal(TemporalType.DATE)
	private Calendar dataDaVenda;

	public Venda() {
		this.items = new ArrayList<Item>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public Item getItemById(int id) {
		for(Item item : this.items) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		this.AtualizarValorTotal();
	}
	
	public void adicionarItem(Item item) throws EstoqueInsuficienteException {
		if(item.getQuantidade() == 0) return;
		if(item.possuiEstoque()) {
			for(Item itemFor : this.getItems()) {
				if (itemFor.isMesmoProduto(item)) {
					itemFor.atualizarQuantidade(item.getQuantidade());
					itemFor.setSubTotal();
					this.AtualizarValorTotal();
					return;
				}
			}
			item.atualizarEstoque();
			item.setSubTotal();
			this.items.add(item);
			this.AtualizarValorTotal();
		} else {
			throw new EstoqueInsuficienteException();
		}
	}
	
	public void adicionarItemIgnoreStock(Item item) {
		if(item.getQuantidade() == 0) return;
		for(Item itemFor : this.getItems()) {
			if (itemFor.isMesmoProduto(item)) {
				itemFor.atualizarQuantidade(item.getQuantidade());
				itemFor.setSubTotal();
				this.AtualizarValorTotal();
				return;
			}
		}
		item.setSubTotal();
		this.items.add(item);
		this.AtualizarValorTotal();
	}
	
	public void atualizarItem(int quantidade, int id) {
		Item item = getItemById(id);
		if((item.getQuantidade() + quantidade) < 1) {
			removerItem(item);
		} else {
			item.atualizarQuantidade(quantidade);
		}
		this.AtualizarValorTotal();
	}
	
	public void removerItem(Item item) {
		this.items.remove(item);
		item.reporEstoque();
		this.AtualizarValorTotal();
	}
	
	public void cancelarVenda() {
		for(Item item : this.items) {
			item.reporEstoque();
			items.remove(item);
		}
		setValorTotal(0.0);
	}
	
	public void AtualizarValorTotal() {
		double total = 0;
		for(Item item : this.items) {
			total += item.getSubTotal();
		}
		this.setValorTotal(total);
	}

	public double getValorTotal() {
		return valorTotal;
	}
	
	public String getValorTotalFormatado() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		return formatador.format(this.valorTotal);
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getDataDaVenda() {
		return dataDaVenda;
	}
	
	public String getDataDaVendaAsString() {
		String data = null;
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy 'as' HH:mm:ss");
			data = formatador.format(this.dataDaVenda.getTime());
		} catch (Exception e) {
			System.out.println("Formato de data inválido!");
			e.printStackTrace();
		}
		return data;
	}

	public void setDataDaVenda(Calendar dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}
	
	public int getQuantidadeItems() {
		return this.items.size();
	}

	@Override
	public String toString() {
		String dados = "Venda " + id;
		dados += "\nData: "+ getDataDaVendaAsString();
		dados += "\nUsuario/Cliente: "+ cliente.getLogin() +"/"+ cliente.getPessoa().getNome();
		dados += "\nQuantidade de Itens: "+ items.size();
		dados += "\nValor Total: "+ valorTotal;
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
		Venda other = (Venda) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataDaVenda == null) {
			if (other.dataDaVenda != null)
				return false;
		} else if (!dataDaVenda.equals(other.dataDaVenda))
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double
				.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}

}
