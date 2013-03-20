package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.Produto;
import model.Venda;
import dao.DAOProduto;

@WebServlet(name = "carrinho", urlPatterns = { "/carrinho" })
public class ServletMeuCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletMeuCarrinho() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Venda venda = (Venda) session.getAttribute("carrinho");
		String operacao = request.getParameter("operacao");
		String itemID = request.getParameter("itemID");
		
		if(venda == null) {
			venda = new Venda();
		}
		
		if(operacao != null && operacao.equals("adicionar")) {
			adicionarItem(itemID, venda);
		}
		
		if(operacao != null && operacao.equals("remover")) {
			removerItem(itemID, venda);
		}
		
		if(operacao != null && operacao.equals("alterar")) {
			String quant = request.getParameter("quantProd");
			atualizarQuantidade(itemID, quant, venda);
		}
		
		session.setAttribute("carrinho", venda);
		String raiz = getServletContext().getInitParameter("raiz");
		response.sendRedirect(raiz + "/pages/carrinho.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void adicionarItem(String itemID, Venda venda) {
		if(itemID != null && itemID != "") {
			Item item = new Item();
			DAOProduto daoProduto = new DAOProduto();
			Produto produto = daoProduto.findById(Integer.parseInt(itemID));
			if(produto != null) {
				item.setId(venda.getQuantidadeItems());
				item.setProduto(produto);
				item.setQuantidade(1);
				venda.adicionarItemIgnoreStock(item);
			}
			daoProduto.close();
		}
	}
	
	private void atualizarQuantidade(String itemID, String quantidade, Venda venda) {
		if(itemID != null && itemID != "") {
			venda.atualizarItem(Integer.parseInt(quantidade), Integer.parseInt(itemID));
		}
		
	}
	
	private void removerItem(String itemID, Venda venda) {
		if(itemID != null && itemID != "") {
			Item item = venda.getItemById(Integer.parseInt(itemID));
			venda.removerItem(item);
		}
	}

}
