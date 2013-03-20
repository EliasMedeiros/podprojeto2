package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.Produto;
import dao.DAOCategoria;
import dao.DAOProduto;

@WebServlet(name = "novoProduto", urlPatterns = { "/novoProduto" })
public class ServletCadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastrarProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String raiz = request.getServletContext().getInitParameter("raiz");
		response.sendRedirect(raiz + "/pages/admin/novoProduto.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/pages/admin/novoProduto.jsp";
		String operacao = request.getParameter("operacao");
		
		String[] parametros = {
				request.getParameter("nomeProd"),
				request.getParameter("precoProd"),
				request.getParameter("descricaoProd"),
				request.getParameter("idProd"),
				request.getParameter("imagemProd")
		};
		String sucesso = "Produto cadastrado com sucesso!";
		if(operacao != null && operacao.equals("editar")) {
			pagina = "/detalhes?prod="+ parametros[3];
			sucesso = "Produto alterado com sucesso!";
		}
		
		for(int i = 0; i < parametros.length-2; i++) {
			if(!validarParametro(parametros[i])) {
				request.setAttribute("msgErroNovoProduto", "Todos os campos devem ser informados!");
				request.getRequestDispatcher(pagina).forward(request, response);
				return;
			}
		}
		
		String[] dadosCat = {
				request.getParameter("selectCategoria"),
				request.getParameter("campoOutraCategoria")
		};
		
		if(!validarDadosCat(dadosCat)) {
			request.setAttribute("msgErroNovoProduto", "Dados da categoria inválidos!");
			request.getRequestDispatcher(pagina).forward(request, response);
			return;
		}
		
		if(!validarNumeros(parametros[1], dadosCat[0])) {
			request.setAttribute("msgErroNovoProduto", "Todos os campos devem ser informados corretamente!");
			request.getRequestDispatcher(pagina).forward(request, response);
			return;
		}
		
		criarProduto(parametros, dadosCat);
		atualizarCategoriaContexto();
		
		request.setAttribute("msgSucessoNovoProduto", sucesso);
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}
	
	private boolean validarParametro(String valor) {
		if(valor == null || valor.equals("")) {
			return false;
		}
		return true;
	}
	
	private boolean validarDadosCat(String[] dadosCat) {
		if(dadosCat[0] == null || dadosCat[0].equals("")) return false;
		if(dadosCat[0].equals("-1")) {
			if(dadosCat[1] == null || dadosCat[1].equals("")) return false;
		}
		return true;
	}
	
	private boolean validarNumeros(String preco, String id) {
		try{
			Double.parseDouble(preco.replace(",", "."));
			Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private void criarProduto(String[] parametros, String[] dadosCat) {
		DAOCategoria daoCategoria = new DAOCategoria();
		DAOProduto daoProduto = new DAOProduto();

		daoProduto.begin();
		daoCategoria.begin();
		
		Categoria categoria = null;
		if(dadosCat[0].equals("-1")) {
			categoria = new Categoria();
			categoria.setNome(dadosCat[1]);
		} else {
			categoria = daoCategoria.findById(Integer.parseInt(dadosCat[0]));
		}
		Produto produto = null;
		if(parametros[3] != null && !parametros[3].equals("")) {
			produto = daoProduto.findById(Integer.parseInt(parametros[3]));
		} else {
			produto = new Produto();
		}
		
		produto.setNome(parametros[0]);
		parametros[1] = parametros[1].replace(",", ".");
		produto.setPreco(Double.parseDouble(parametros[1]));
		produto.setDescrição(parametros[2]);
		produto.setEstoque(50);
		produto.setCategoria(categoria);
		categoria.adicionarProduto(produto);
		if(dadosCat[0].equals("-1")) {
			daoCategoria.persist(categoria);
		} else {
			daoCategoria.merge(categoria);
		}
		if(parametros[4] != null && !parametros[4].equals("")) {
			produto.setImagem(parametros[4]);
		}
		if(parametros[3] != null && !parametros[3].equals("")) {
			daoProduto.merge(produto);
		} else {
			daoProduto.persist(produto);
		}
		
		daoProduto.commit();
		daoCategoria.commit();
		daoProduto.close();
		daoCategoria.close();
	}
	
//	private Categoria criarCategoria(String[] dados) {
//		DAOCategoria daoCategoria = new DAOCategoria();
//		Categoria categoria = null;
//		if(dados[0].equals("-1")) {
//			daoCategoria.begin();
//			categoria = new Categoria();
//			categoria.setNome(dados[1]);
//			daoCategoria.persist(categoria);
//			daoCategoria.close();
//		} else {
//			categoria = daoCategoria.findById(Integer.parseInt(dados[0]));
//			daoCategoria.close();
//		}
//		
//		return categoria;
//	}
	
	private void atualizarCategoriaContexto() {
		DAOCategoria daoCategoria = new DAOCategoria();
		List<Categoria> categorias = daoCategoria.findAllOrderBy("nome");
		getServletContext().setAttribute("categorias", categorias);
		daoCategoria.close();
	}
	
}
