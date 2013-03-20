<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty" %>

<div id="left">
	<c:if test="${admin eq true }">
		<div>
			<img src="${initParam['raiz'] }/img/administracao.jpg" /> <br />
			<ul>
				<li><a href="${initParam['raiz'] }/pages/admin/novoProduto.jsp">Cadastrar Produto</a></li>
			</ul>
		</div>
	</c:if>

	<div>
		<img src="${initParam['raiz'] }/img/categorias.jpg" /> <br />
		<ul>
			<c:forEach var="categoria" items="${categorias }">
				<li><a href="${initParam['raiz'] }/produtos?categoria=${categoria.nome }&page=1&show=8&orderBy=nome-Asc">${categoria.nome }</a></li>
			</c:forEach>
		</ul> 
	</div>
</div>