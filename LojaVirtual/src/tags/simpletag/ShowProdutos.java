package tags.simpletag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.Categoria;
import model.Produto;
import dao.DAOCategoria;
import dao.DAOProduto;

public class ShowProdutos extends SimpleTagSupport {
	
	private String categoria;
	private Integer page;
	private Integer show;
	private String orderBy;
	
	public void doTag() throws JspException, IOException {
		if(!verificarParams()) {
			getJspContext().getOut().print("<br/>Nenhum produto encontrado!<br/>");
			return;
		}
		PageContext context = (PageContext) getJspContext();
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
		
		getJspContext().getOut().println(saida);
	}
	
	private boolean verificarParams() {
		if(categoria == null || categoria == "") {
			return false;
		}
		DAOCategoria daoCategoria = new DAOCategoria();
		Categoria cat = daoCategoria.findByNome(categoria);
		if(cat == null) {
			return false;
		}
		daoCategoria.close();
		if(page == null || page < 1) {
			setPage(1);
		}
		if(show == null || show < 8) {
			setShow(8);
		}
		if(orderBy == null || orderBy == "") {
			setOrderBy("nome-Asc");
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private List<Produto> getProdutos() {
		DAOProduto daoProduto = new DAOProduto();
		String[] orderByArray = orderBy.split("-");
		
		String query = "select p from Produto p where p.categoria.nome = '" + categoria +"' ";
		query += "order by p."+ orderByArray[0] +" "+ orderByArray[1];
		
		return daoProduto.findAllByQuery(query,(page-1)*show,show);
		
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setShow(int show) {
		this.show = show;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
