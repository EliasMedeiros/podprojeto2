<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="scriptless" %>

<div id="main">

	<div id="login">
		<c:if test="${user eq null}">
			<form method="POST" action="">
				Usuário: <input name="login" type="text" /> Senha: <input
					name="pass" type="password" /> <input type="submit" value="Ok" />
			</form>
		</c:if>
		<c:if test="${user ne null}">
				<div id="bemvindo">Bem Vindo, <i>${user.pessoa.nome }</i>! </div> <div id="sair"> <a
				href="${initParam['raiz'] }/logout"><img class="logout" src="${initParam['raiz'] }/img/logout.jpg" alt="Logout" title="Sair" /></a></div>
		</c:if>
	</div>

	<div id="logo"> </div>

		<div id="menu">
			<span>
			<a href="${initParam['raiz'] }/"><img src="${initParam['raiz'] }/img/home.jpg" /></a>
			<a href="${initParam['raiz'] }/pages/meusDados.jsp"><img src="${initParam['raiz'] }/img/dados.jpg" /></a>
			<c:if test="${admin ne true }">
			<a href="${initParam['raiz'] }/carrinho" ><img src="${initParam['raiz'] }/img/carrinho.jpg" /></a>
			</c:if>
			</span>
		</div>
		
		<jsp:doBody />
</div>		