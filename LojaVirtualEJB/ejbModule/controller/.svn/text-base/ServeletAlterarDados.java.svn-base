package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import model.Usuario;
import dao.DAOUsuario;

@WebServlet(name = "alterar", urlPatterns = { "/alterar" })
public class ServeletAlterarDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServeletAlterarDados() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String raiz = request.getServletContext().getInitParameter("raiz");
		response.sendRedirect(raiz + "/pages/meusDados.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("alterar") == null) {
			request.setAttribute("alterar", true);
		}
		String con = request.getParameter("con");
		if(con != null && con.equals("ok")) {
			HttpSession session = request.getSession();
			Usuario user = (Usuario) session.getAttribute("user");
			if(user != null) {
				user = alterarUsuario(user,request);
				session.setAttribute("user", user);
				request.setAttribute("sucessoMsgAlteracao", "Dados atualizados com sucesso!");
			}
			request.setAttribute("alterar", null);
		}
		request.getRequestDispatcher("pages/meusDados.jsp").forward(request, response);
		
	}
	
	private Usuario alterarUsuario(Usuario user, HttpServletRequest request) {
		DAOUsuario daoUsuario = new DAOUsuario();
		Pessoa pessoa = user.getPessoa();
		pessoa.setNome(request.getParameter("tnome"));
		pessoa.setEmail(request.getParameter("temail"));
		pessoa.setRg(request.getParameter("trg"));
		pessoa.setCpf(request.getParameter("tcpf"));
		pessoa.setDatanascimentoAsString(request.getParameter("tdata"));
		pessoa.getEndereco().setEndereco(request.getParameter("tendereco"));
		pessoa.getEndereco().setNumero(request.getParameter("tnum"));
		pessoa.getEndereco().setComplemento(request.getParameter("tcomp"));
		pessoa.getEndereco().setBairro(request.getParameter("tbairro"));
		pessoa.getEndereco().setCidade(request.getParameter("tcidade"));
		pessoa.getEndereco().setEstado(request.getParameter("testado"));
		pessoa.getEndereco().setCep(request.getParameter("tcep"));
		
		daoUsuario.begin();
		daoUsuario.merge(user);
		daoUsuario.commit();
		return user;
	}

}
