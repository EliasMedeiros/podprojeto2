package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import dao.DAOProduto;

@WebServlet(name = "detalhes", urlPatterns = { "/detalhes" })
public class ServletDetalhesProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetalhesProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("prod");
		String raiz = getServletContext().getInitParameter("raiz");
		if(id == null || id == "") {
			response.sendRedirect(raiz + "/pages/produtos.jsp");
		}
		
		String operacao = request.getParameter("operacao");
		
		DAOProduto daoProduto = new DAOProduto();
		Produto produto = daoProduto.findById(Integer.parseInt(id));
		
		request.setAttribute("produtoDetalhes", produto);
		if(operacao != null && operacao.equals("editar")) {
			request.getRequestDispatcher("/pages/admin/editarProd.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/pages/detalhes.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
