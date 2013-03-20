<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main:body titlePage="Finalizar Compra">

	<main:MainLayout>
	
		<div id="content">
			<main:Menu/>
			
			<div id="right">
				<c:if test="${user eq null }">
					<main:loginForm/>
				</c:if>
				
				<c:if test="${user ne null }">
					<img src="${initParam['raiz'] }/img/finalizar.jpg" />
					<center>
					<c:if test="${carrinho eq null or carrinho.quantidadeItems < 1}">
						<h4>Nenhum produto no carrinho!</h4>
					</c:if>
					<c:if test="${carrinho ne null and carrinho.quantidadeItems gt 0 and admin ne true}">
						<h4>Em construção!</h4>
						<img src="${initParam['raiz'] }/img/em_construcao.png" alt="Em Construção" />
					</c:if>
					<c:if test="${admin eq true }">
						<h4 class="aviso">Administradores não podem realizar compras!</h4>
					</c:if>
					</center>
				</c:if>
			
			</div>
		
		</div>
	
	</main:MainLayout>

</main:body>