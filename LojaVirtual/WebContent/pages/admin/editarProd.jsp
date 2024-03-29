<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main:body titlePage="Editar Produto">
	<main:MainLayout>
		<c:if test="${admin ne true or produtoDetalhes eq null }">
			<c:redirect url="/" />
		</c:if>
		
		<div id="content">
			<main:Menu />
			
			<div id="right">
				
				<img src="${initParam['raiz'] }/img/editarProd.jpg" />
				<br /><br />
				<c:if test="${msgErroNovoProduto ne null }"><center><span class="erroMsg">${msgErroNovoProduto }</span></center><br /></c:if>
				<c:if test="${msgSucessoNovoProduto ne null }"><center><span class="msgSucesso">${msgSucessoNovoProduto }</span></center><br /></c:if>
				<div id="formNovoProd">
					<form method="POST" action="${initParam['raiz'] }/novoProduto?operacao=editar">
					<input type="hidden" name="idProd" value="${produtoDetalhes.id }" />
					<table>
						<tr>
							<th><label for="nomeProd">Nome: </label></th>
							<td><input type="text" name="nomeProd" id="nomeProd" value="${produtoDetalhes.nome }" maxlength="25" /></td>
						</tr>
						<tr>
							<th><label for="precoProd">Pre�o: </label></th>
							<td><input type="text" name="precoProd" id="precoProd" value="${produtoDetalhes.preco }" /></td>
						</tr>
						<tr>
							<th><label for="selectCategoria">Categoria: </label></th>
							<td>
								<select id="selectCategoria" name="selectCategoria" onchange="outraCategoria();">
									<option>Selecione...</option>
									<c:forEach var="categoria" items="${categorias }" varStatus="status">
										<c:if test="${produtoDetalhes.categoria.id ne categoria.id }">
											<option value="${categoria.id }">${categoria.nome } </option>
										</c:if>
										<c:if test="${produtoDetalhes.categoria.id eq categoria.id }">
											<option value="${categoria.id }" selected="selected" >${categoria.nome }</option>
										</c:if>
									</c:forEach>
									<option value=-1>Outra categoria</option>
								</select>
								&nbsp;
								<input type="text" id="campoOutraCategoria" name="campoOutraCategoria" />
							</td>
						</tr>
						<tr>
							<th><label for="descricaoProd">Descri��o: </label></th>
							<td><textarea name="descricaoProd" id="descricaoProd" cols="50" rows="5" maxlength="245" onkeydown="limitText(this, 245)" onkeyup="limitText(this, 245">${produtoDetalhes.descri��o }</textarea></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td colspan="2"><hr></td></tr>
						<tr>
							<td colspan="2"><input type="submit" value="Alterar" />  
							<input type="reset" value="Apagar" /> 
							<input type="button" value="Cancelar" onclick="javascript:window.location = '${initParam['raiz'] }/'" /></td>
						</tr>
					</table>
					</form>
				</div>
				
			</div>
		</div>

	</main:MainLayout>
</main:body>