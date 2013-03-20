package controller;

import java.util.List;

import javax.ejb.Remote;

import model.Categoria;
import model.Produto;
import model.Usuario;

@Remote
public interface ControladorGeralRemote {

	public String internacionalizar();
	public void salvar(Usuario usuario) ;
	
	//-------- MÉTODOS DE CADASTRAR ------------
	public void cadastrarUsuario (Usuario usuario);
	public void cadastrarProduto(Produto produto);
	
		//-------- MÉTODOS DE LISTAR ------------
	public List<Produto> listarProdutos();
	public List<Produto> listarProdutosPorCategoria(String id_cat);
	public List<Produto> listarProdutosDestaque(int quant);
	public List<Categoria> listarCategorias();

	//-------- MÉTODOS DE PESQUISAR ------------
	public Produto PesquisarProduto(int id_prod);
	public Usuario PesquisarUsuario(String login);
	public Categoria PesquisarCategoria(int id_cat);

	//-------- MÉTODO DE LOGAR ----------------
	public Usuario logar(String login, String senha);
}
