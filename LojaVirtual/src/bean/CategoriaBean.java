package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Categoria;
import controller.ControladorGeralRemote;

@ManagedBean(name="categoria")
@SessionScoped
public class CategoriaBean {
	
	@EJB
	private ControladorGeralRemote controlador;
	
	private String nome;
	private List<Categoria> categorias;
	
	public CategoriaBean() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Categoria> getListaCategorias() {
		List<Categoria> lista = controlador.listarCategorias();
		return lista;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
