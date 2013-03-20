package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import model.Pessoa;
import model.Telefone;
import model.Usuario;
import dao.DAOPessoa;
import dao.DAOUsuario;

@WebServlet(name = "cadastrar", urlPatterns = { "/cadastrar" })
public class ServletCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastrar() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String raiz = request.getServletContext().getInitParameter("raiz");
		response.sendRedirect(raiz + "/pages/cadastrar.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Usuario user = validarCampos(request);
		if (user == null) {
			SetAtributos(request);
			request.getRequestDispatcher("pages/cadastro.jsp").forward(request, response);
			return;
		}
		request.setAttribute("msgSucessoCadastro", "Cadastro Realizado com Sucesso!");
		request.getRequestDispatcher("pages/meusDados.jsp").forward(request, response);
	}
	
	@SuppressWarnings("rawtypes")
	private void SetAtributos(HttpServletRequest request) {
		Map params = request.getParameterMap();
		Iterator i = params.keySet().iterator();
		while ( i.hasNext() )
		{
		String key = (String) i.next();
		String value = ((String[]) params.get( key ))[ 0 ];
		request.setAttribute(key, value);
		}		
	}

	private Usuario validarCampos(HttpServletRequest request) {
		Usuario user = new Usuario();
		String campo1;
		String campo2;
		
		campo1 = request.getParameter("clogin");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Login' deve ser preenchido.");
			return null;
		}
		DAOUsuario daoUsuario = new DAOUsuario();
		Usuario usuario = daoUsuario.findByLogin(campo1);
		if(usuario != null) {
			request.setAttribute("msgErroCadastrar", "Nome de usuário não disponivel!");
			return null;
		}
		user.setLogin(campo1);
		
		campo1 = request.getParameter("cpass");
		campo2 = request.getParameter("cpass2");  
		if (campo1 == "" || campo1 == null || campo2 == "" || campo2 == null) {
			request.setAttribute("msgErroCadastrar", "Os campos 'Senha' e 'Repetir Senha' devem ser preenchidos.");
			return null;
		}else if (!campo1.equals(campo2)) {
			request.setAttribute("msgErroCadastrar", "Erro: Senhas diferentes!");
			return null;
		}
		
		user.setSenha(campo1);
		
		Pessoa pessoa = new Pessoa();
		campo1 = request.getParameter("cemail");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Email' deve ser preenchido.");
			return null;
		}
		pessoa.setEmail(campo1);
		
		campo1 = request.getParameter("cnome");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Nome' deve ser preenchido.");
			return null;
		}
		pessoa.setNome(campo1);
		
		campo1 = request.getParameter("ccpf");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'CPF' deve ser preenchido.");
			return null;
		}
		pessoa.setCpf(campo1);
		
		campo1 = request.getParameter("crg");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'RG' deve ser preenchido.");
			return null;
		}
		pessoa.setRg(campo1);
		
		campo1 = request.getParameter("cdataDia");
		campo2 = request.getParameter("cdataMes");
		String campo3 = request.getParameter("cdataAno");
		
		System.out.println(campo1);
		System.out.println(campo3);
		if (!Pattern.matches("^[0-9]*$", campo1)){
			request.setAttribute("msgErroCadastrar", "O campo 'Dia' deve ser um número.");
			return null;
		}
		else if(!Pattern.matches("^[0-9]*$", campo3)){
			request.setAttribute("msgErroCadastrar", "O campo 'Ano' deve ser um número.");
			return null;
		}
		else if(campo1 == null || campo1 == "" || campo2 == null || campo2 == "" || campo3 == null || campo3 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Data de Nascimento' devem ser preenchidos.");
			return null;
		}
		pessoa.setDatanascimentoGerada(Integer.parseInt(campo1), Integer.parseInt(campo2), Integer.parseInt(campo3));
		
		Endereco end = new Endereco();
		
		campo1 = request.getParameter("cendereco");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Endereço' deve ser preenchido.");
			return null;
		}
		end.setEndereco(campo1);
		
		campo1 = request.getParameter("cnum");
		
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Número' deve ser preenchido.");
			return null;
		}
		end.setNumero(campo1);
		
		campo1 = request.getParameter("cbairro");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Bairro' deve ser preenchido.");
			return null;
		}
		end.setBairro(campo1);
		
		campo1 = request.getParameter("ccomp");
		if (!Pattern.matches("^\n*$", campo1)){
			request.setAttribute("msgErroCadastrar", "O campo 'Dia' deve ser um número.");
			return null;
		}
		end.setComplemento(campo1);
		
		campo1 = request.getParameter("ccep");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'CEP' deve ser preenchido.");
			return null;
		}
		end.setCep(campo1);
		
		campo1 = request.getParameter("ccidade");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Cidade' deve ser preenchido.");
			return null;
		}
		end.setCidade(campo1);
		
		campo1 = request.getParameter("cestado");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Estado' deve ser preenchido.");
			return null;
		}
		end.setEstado(campo1);
		
		pessoa.setEndereco(end);
		end.setPessoa(pessoa);
		
		Telefone tel = new Telefone();
		Telefone tel2 = new Telefone();
		Telefone tel3 = new Telefone();
		campo1 = request.getParameter("ctelcel");
		campo2 = request.getParameter("ctelres");
		campo3 = request.getParameter("ctelcom");
		if (campo1 == null || campo1 == "") {
			request.setAttribute("msgErroCadastrar", "O campo 'Telefone Celular' deve ser preenchido.");
			return null;
		}
		tel.setNumero(campo1);
		tel.setPessoa(pessoa);
		tel.setTipo(Telefone.CELULAR);
		pessoa.adicionarTelefone(tel);
		
		if(campo2 != null && campo2 != "") {
			tel2.setNumero(campo2);
			tel2.setPessoa(pessoa);
			tel2.setTipo(Telefone.RESIDENCIAL);
			pessoa.adicionarTelefone(tel2);
		}
		
		if(campo3 != null && campo3 != "") {
			tel3.setNumero(campo3);
			tel3.setPessoa(pessoa);
			tel3.setTipo(Telefone.COMERCIAL);
			pessoa.adicionarTelefone(tel3);
		}
		
		DAOPessoa daoPessoa = new DAOPessoa();
		daoPessoa.begin();
		pessoa.setUsuario(user);
		user.setPessoa(pessoa);
		daoPessoa.persist(pessoa);
		daoPessoa.commit();
		
		return user;
	}

}
