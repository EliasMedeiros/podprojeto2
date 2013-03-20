package bean;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Produto;
import controller.ControladorGeralRemote;

@ManagedBean(name="produtosBean")
@SessionScoped
public class ProdutoBean {
	private Integer quant;
	private String categoria;
	private List<Produto> produtos;
	private String nome;
	private Integer caterogia;
	private Integer orderBy;
	private Integer page;
	private Integer show;
	
	@EJB
	private ControladorGeralRemote controlador;

	public List<Produto> getListarLivros() {
		return controlador.listarProdutos();
	}
	
	public List<Produto> getListarLivrosCategoria() {
		
		FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String catId = paramMap.get("categoria");
		return controlador.listarProdutosPorCategoria(catId);
	}

	public Produto getLivro() {
		
		FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        int projectId = Integer.parseInt(paramMap.get("prod"));
        
		return controlador.PesquisarProduto(projectId);
	}

	public List<Produto> getlistarLivrosDestaque() {
        return controlador.listarProdutosDestaque(8);
	}
	
	public Integer getQuant() {
        return quant;
	}
	
	public void setQuant(Integer quant) {
        this.quant = quant;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCaterogia() {
		return caterogia;
	}

	public void setCaterogia(Integer caterogia) {
		this.caterogia = caterogia;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	
/*	PageContext context = (PageContext) getJspContext();
	Boolean admin = (Boolean) ((HttpServletRequest)context.getRequest()).getAttribute("admin");
	
	String saida = "";
	List<Produto> produtos = getProdutos();
	String raiz = context.getServletContext().getInitParameter("raiz");

	for(Produto produto : produtos) {
		saida += "<div id='produto'>";
		saida += "<br /> <a href='"+ raiz +"/detalhes?prod="+ produto.getId() +"'><img class='imagem' src='"+ raiz +"/img/imagemProdutos/"+ produto.getImagem() +"' /></a>";
		saida += "<br /> <a href='"+ raiz +"/detalhes?prod="+ produto.getId() +"'>"+ produto.getNome()+"</a>";
		saida += "<br /> <span class='precoProd'>R$ "+ produto.getPrecoFormatado() +"</span> <br />";
		if(admin != null && admin) {
			saida += "<br /> <a href='"+ raiz +"/detalhes?prod="+ produto.getId() +"&operacao=editar'><img src='"+ raiz +"/img/editar.jpg' alt='Editar' title='Editar' /></a>";
		} else {
			saida += "<br /> <a href='"+ raiz +"/carrinho?operacao=adicionar&itemID="+ produto.getId() +"'><img src='"+ raiz +"/img/comprar.jpg' alt='Adicionar ao Carrinho' title='Adicionar ao Carrinho' /></a>";
		}
		saida += "</div>";
	}
	
	getJspContext().getOut().println(saida);*/
}