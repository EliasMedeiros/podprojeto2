<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main:body titlePage="Detalhes">

	<main:MainLayout>
	
		<div id="content">
			<main:Menu/>
			
			<div id="right">
			<div id="conteudo">
				<c:if test="${produtoDetalhes eq null }">
					<c:redirect url="/pages/produtos.jsp" />
				</c:if>
				<c:if test="${msgErroNovoProduto ne null }"><center><span class="erroMsg">${msgErroNovoProduto }</span></center><br /></c:if>
				<c:if test="${msgSucessoNovoProduto ne null }"><center><span class="msgSucesso">${msgSucessoNovoProduto }</span></center><br /></c:if>
				<div id="prodDetailIMG">
					<img class="imagem" src="${initParam['raiz'] }/img/imagemProdutos/${produtoDetalhes.imagem }" />
				</div>
				
				<div id="prodDetailInfo">
					<h3>${produtoDetalhes.nome }</h3>
					<h3>R$ ${produtoDetalhes.precoFormatado }</h3>
					<c:if test="${admin ne true }">
						<a href="${initParam['raiz'] }/carrinho?operacao=adicionar&itemID=${produtoDetalhes.id }"><img src="${initParam['raiz'] }/img/comprar.jpg" alt="Adicionar ao Carrinho" title="Adicionar ao Carrinho" /></a>
					</c:if>
					<c:if test="${admin eq true }">
						<a href="${initParam['raiz'] }/detalhes?prod=${produtoDetalhes.id }&operacao=editar"><img src="${initParam['raiz'] }/img/editar.jpg" alt="Editar" title="Editar" /></a>
					</c:if>
				</div>
			
				<div id="prodDetailDesc">
					<h4>Descrição do Produto:</h4>
					${produtoDetalhes.descrição }
				</div>
			
			</div>
			</div>
		</div>
	
	</main:MainLayout>
	
</main:body>