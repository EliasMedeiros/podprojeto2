<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty" %>

<%@ attribute name="quant" required="true" rtexprvalue="true" description="Informa a quantidade de produtos em destaque que deve aparece" %>

<c:forEach var="produto" items="${produtosByQuery }">
	<div id="produto">
		<br /> <a href="${initParam['raiz'] }/detalhes?prod=${produto.id }"><img class="imagem" src="${initParam['raiz'] }/img/imagemProdutos/${produto.imagem }" /></a> 
		<br /> <a href="${initParam['raiz'] }/detalhes?prod=${produto.id }">${produto.nome }</a> 
		<br /> <span class="precoProd">R$ ${produto.precoFormatado }</span> <br />
		<br /> 
		<c:if test="${admin ne true }">
			<a href="${initParam['raiz'] }/carrinho?operacao=adicionar&itemID=${produto.id }"><img src="${initParam['raiz'] }/img/comprar.jpg" alt="Adicionar ao Carrinho" title="Adicionar ao Carrinho" /></a>
		</c:if>
		<c:if test="${admin eq true }">
			<a href="${initParam['raiz'] }/detalhes?prod=${produto.id }&operacao=editar"><img src="${initParam['raiz'] }/img/editar.jpg" alt="Editar" title="Editar" /></a>
		</c:if>
	</div>
</c:forEach>
