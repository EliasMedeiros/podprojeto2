<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ tag body-content="empty" %>

<div id="conteudoLogin">
<div id="autenticar">
<form method="POST" action="">
	<h3>Autenticação</h3>
	<c:if test="${msgSucessoCadastro ne null }"><center><span class="msgSucesso">${msgSucessoCadastro }</span></center><br /></c:if>
	<c:if test="${erroMsgLogin ne null }"><center><span class="erroMsg">${erroMsgLogin }</span></center></c:if>
	<label for="user">Login: </label><br />
	<input id="user" name="login" type="text" maxlength="25" /><br />
	
	<label for="pass">Senha: </label><br />
	<input id="pass" name="pass" type="password" maxlength="25" /><br />

	<a href="${initParam['raiz'] }/pages/cadastro.jsp">Cadastrar</a>
	<br /><br />
	<input type="submit" value="Enviar" />
</form>
</div>
<div id="lembrar">
	<h3>Esqueci minha senha!</h3>
	<c:if test="${sucessoRecuperar eq null }">
	<form method="POST" action="">
		<c:if test="${erroMsgRecuperar ne null }"><center><span class="erroMsg">${erroMsgRecuperar }</span></center></c:if>
		<label for="user">Login:</label> <br />
		<input id="user" name="user" type="text" maxlength="25" /><br />
		<input type="hidden" name="recuperar" value="ok" />
		<br />
		<input type="submit" value="Recuperar" />
	</form>
	</c:if>
	<c:if test="${sucessoRecuperar ne null }">
		<span class="sucessoMsg">${sucessoRecuperar }</span>
	</c:if>
</div>
</div>
