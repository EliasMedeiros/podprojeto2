package dao;

import java.util.List;

import javax.ejb.Stateless;

import model.Produto;

@Stateless
public class DAOProduto extends DAOJPA<Produto> {
	
	public DAOProduto() {
		super();
	}
	
	public Produto findById(int id) {
		return (Produto) super.findByQuery("SELECT p FROM Produto p WHERE p.id = "+ id);
	}
	
	public long getQuantidadeDeProdutos() {
		return (Long) super.findByQuery("SELECT count(p) FROM Produto p");
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> findDestaques(int quant) {
		return (List<Produto>) super.findAllByQuery("SELECT p FROM Produto p ORDER BY p.quantidadeVendida DESC", quant);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findByCategoria(String nome_cat) {
		
		return (List<Produto>) super.findAllByQuery("SELECT p FROM Produto p where categoria_id = (select c.id from Categoria c where c.nome = '" + nome_cat + "')");
	}

}
