package dao;

import java.util.List;

import javax.ejb.Stateless;

import model.Categoria;

@Stateless
public class DAOCategoria extends DAOJPA<Categoria> {
	
	public DAOCategoria() {
		super();
	}
	
	public Categoria findById(int id) {
		return (Categoria) super.findByQuery("SELECT c FROM Categoria c WHERE c.id = "+ id);
	}
	
	public Categoria findByNome(String nome) {
		return (Categoria) super.findByQuery("SELECT c FROM Categoria c WHERE c.nome = '"+ nome +"'");
	}
	
	public long getQuantidadeDeCategorias() {
		return (Long) super.findByQuery("SELECT count(c) FROM Categoria c");
	}
	
	public int getQuantidadeProdutoCategoria(String categoria) {
		return (Integer) super.findByQuery("SELECT SIZE(c.produtos) FROM Categoria c WHERE c.nome = '"+ categoria +"'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findAllOrderBy(String campo) {
		return (List<Categoria>) super.findAllByQuery("SELECT c FROM Categoria c ORDER BY c."+ campo);
	}

}
