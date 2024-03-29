package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCategoria;

@WebServlet(name = "produtos", urlPatterns = { "/produtos" })
public class ServletExibirProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletExibirProdutos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemsPerPage = Integer.parseInt(request.getParameter("show"));
		int quantItems = 0;
		String categoria = request.getParameter("categoria");
			
		DAOCategoria daoCategoria = new DAOCategoria();
		if(categoria != null && !categoria.equals("")) {
			quantItems = daoCategoria.getQuantidadeProdutoCategoria(categoria);
		}
		if(quantItems > 0) {
			
			int quantPages = quantItems / itemsPerPage;
				
			if(quantItems % itemsPerPage != 0) {
				quantPages++;
			}
				
			request.setAttribute("quantPages", quantPages);
		} else {
			request.setAttribute("noResults", "Nenhum produto encontrado!");
		}
			
		request.getRequestDispatcher("/pages/produtos.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
