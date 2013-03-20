package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import model.Categoria;
import model.Produto;
import model.Usuario;
import dao.DAOCategoria;
import dao.DAOCliente;
import dao.DAOEndereco;
import dao.DAOPessoa;
import dao.DAOProduto;
import dao.DAOUsuario;
import dao.DAOVenda;

@Stateless
public class ControladorGeral implements ControladorGeralRemote{
	@EJB
	private DAOCategoria daoCategoria;

	@EJB
	private DAOCliente daoCliente;

	@EJB
	private DAOEndereco daoEndereco;

	@EJB
	private DAOPessoa daoPessoa;

	@EJB
	private DAOProduto daoProduto;

	@EJB
	private DAOUsuario daoUsuario;

	@EJB
	private DAOVenda daoVenda;
	
	public ControladorGeral() {
		super();
	}

	private String internacional;
	private List<Produto> produtos    = new ArrayList<Produto>();
	private List<Categoria> categorias = new ArrayList<Categoria>();

	public DAOCategoria getDaoCategoria() {
		return daoCategoria;
	}

	public void setDaoCategoria(DAOCategoria daoCategoria) {
		this.daoCategoria = daoCategoria;
	}

	public DAOCliente getDaoCliente() {
		return daoCliente;
	}

	public void setDaoCliente(DAOCliente daoCliente) {
		this.daoCliente = daoCliente;
	}

	public DAOEndereco getDaoEndereco() {
		return daoEndereco;
	}

	public void setDaoEndereco(DAOEndereco daoEndereco) {
		this.daoEndereco = daoEndereco;
	}

	public DAOPessoa getDaoPessoa() {
		return daoPessoa;
	}

	public void setDaoPessoa(DAOPessoa daoPessoa) {
		this.daoPessoa = daoPessoa;
	}

	public DAOProduto getDaoProduto() {
		return daoProduto;
	}

	public void setDaoProduto(DAOProduto daoProduto) {
		this.daoProduto = daoProduto;
	}

	public DAOUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public DAOVenda getDaoVenda() {
		return daoVenda;
	}

	public void setDaoVenda(DAOVenda daoVenda) {
		this.daoVenda = daoVenda;
	}

	public String getInternacional() {
		return internacional;
	}

	public void setInternacional(String internacional) {
		this.internacional = internacional;
	}
	
	public String internacionalizar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getViewRoot().setLocale(new Locale(internacional));
		
		return null; 
	}

	@Override
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	//-------- MÉTODOS DE CADASTRAR ------------
	public void cadastrarUsuario (Usuario usuario){
		daoUsuario.persist(usuario);
	}
	
	public void cadastrarProduto(Produto produto){
		daoProduto.persist(produto);
	}
	
	//-------- MÉTODOS DE LISTAR ------------
	public List<Produto> listarProdutos(){
		produtos = daoProduto.findAll();
		return produtos;
	}

	public List<Categoria> listarCategorias(){
		categorias = daoCategoria.findAll();
		return categorias;
	}
	
	public List<Produto> listarProdutosPorCategoria(String nome_cat){
		produtos = daoProduto.findByCategoria(nome_cat);
		return produtos;
	}
	public List<Produto> listarProdutosDestaque(int quant){
		produtos = daoProduto.findDestaques(quant);
		return produtos;
	}

	//-------- MÉTODOS DE PESQUISAR ------------
	public Produto PesquisarProduto(int id_prod){
		Produto produto = daoProduto.findById(id_prod);
		return produto;
	}

	public Usuario PesquisarUsuario(String login){
		Usuario usuario = daoUsuario.findByLogin(login);
		return usuario;
	}

	public Categoria PesquisarCategoria(int id_cat){
		Categoria categoria = daoCategoria.findById(id_cat);
		return categoria;
	}

	//-------- MÉTODO DE LOGAR ----------------
	
	public Usuario logar(String login, String senha) {
//		Usuario usuario = daoUsuario.fazerLogin(login, senha);
		return daoUsuario.findByLoginSenha(login, senha);
	}
}