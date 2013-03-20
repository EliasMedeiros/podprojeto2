<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="j" uri="projeto.simpletags" %>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags" %>
<main:body titlePage="Listagem Produtos">

	<main:MainLayout>
	
		<div id="content">

			<main:Menu/>
			
			<div id="right">
				<img src="${initParam['raiz'] }/img/produtoslist.jpg" />
				<br /><br />
				<main:filtroItens />
				<c:if test="${quantPages ne null}">
					<main:numeroPaginas/>
				</c:if>
				<j:ShowProdutos show="${param.show }" page="${param.page }" orderBy="${param.orderBy }" categoria="${param.categoria }"></j:ShowProdutos>
				<br />
				<c:if test="${quantPages ne null}">
					<main:numeroPaginas/>
				</c:if>
			</div>
		</div>
		
	</main:MainLayout>

</main:body>