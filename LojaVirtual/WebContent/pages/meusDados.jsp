<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main:body titlePage="Meus Dados">
	<main:MainLayout>
		<div id="content">

			<main:Menu/>

			<div id="right">
				
				<c:if test="${user eq null }">
					<main:loginForm/>
				</c:if>
				
				<c:if test="${user ne null }">
				<img src="${initParam['raiz'] }/img/dadosuser.jpg" />
					<form method="post" action="${initParam['raiz'] }/alterar">
					<br /><br />
					<c:if test="${alterar eq null or alterar eq false}">
					<c:if test="${sucessoMsgAlteracao ne null }"><center><span class="msgSucesso">${sucessoMsgAlteracao }</span></center><br /></c:if>
					<table cellspacing="3" id="tabelaMeusDados">
						<tr>
							<th>Nome de Usuário:</th>
							<td>${user.login }</td>
						</tr>
						<tr>
							<th>Nome:</th>
							<td>${user.pessoa.nome }</td>
						</tr>
						<tr>
							<th>E-Mail:</th>
							<td>${user.pessoa.email }</td>
						</tr>
						<tr>
							<th>RG:</th>
							<td>${user.pessoa.rg }</td>
						</tr>
						<tr>
							<th>CPF:</th>
							<td>${user.pessoa.cpf }</td>
						</tr>
						<tr>
							<th>Data de Nascimento:</th>
							<td>${user.pessoa.datanascimentoAsString }</td>
						</tr>
						<c:forEach var="tel" items="${user.pessoa.telefone }">
						<tr>
							<th>Telefone ${tel.tipoAsString }:</th>
							<td>${tel.numero }</td>
						</tr>
						</c:forEach>
						<tr>
							<th>Endereço:</th>
							<td>${user.pessoa.endereco.endereco2 }</td>
						</tr>
						<tr>
							<th>Bairro:</th>
							<td>${user.pessoa.endereco.bairro }</td>
						</tr>
						<tr>
							<th>Cidade:</th>
							<td>${user.pessoa.endereco.cidade }</td>
						</tr>
						<tr>
							<th>Estado:</th>
							<td>${user.pessoa.endereco.estado }</td>
						</tr>
						<tr>
							<th>CEP:</th>
							<td>${user.pessoa.endereco.cep }</td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td colspan="2"><hr></td></tr>
						<tr>
							<td><input type="submit" value="Alterar Dados" /></td>
						</tr>
					</table>
					</c:if>
					
					<c:if test="${alterar ne null }">
					<table cellspacing="3" id="tabelaMeusDados">
						<tr>  
							<th><label for="tnome">Nome:</label></th>
							<td><input id="tnome" name="tnome" type="text" value="${user.pessoa.nome }" /></td>
						</tr>
						<tr>
							<th><label for="temail">E-Mail:</label></th>
							<td><input id="temail" name="temail" type="text" value="${user.pessoa.email }" /></td>
						</tr>
						<tr>
							<th><label for="trg">RG:</label></th>
							<td><input id="trg" name="trg" type="text" value="${user.pessoa.rg }" /></td>
						</tr>
						<tr>
							<th><label for="tcpf">CPF:</label></th>
							<td><input id="tcpf" name="tcpf" type="text" value="${user.pessoa.cpf }" /></td>
						</tr>
						<tr>
							<th><label for="tdata">Data de Nascimento:</label></th>
							<td><input id="tdata" name="tdata" type="text" value="${user.pessoa.datanascimentoAsString }" /></td>
						</tr>
<%-- 						<c:forEach var="tel" items="${user.pessoa.telefone }"> --%>
<!-- 						<tr> -->
<%-- 							<th><label for="t${tel.id }">Telefone ${tel.tipoAsString }:</label></th> --%>
<%-- 							<td><input id="t${tel.id }" name="${tel.tipoAsString }" type="text" value="${tel.numero }" /></td> --%>
<!-- 						</tr> -->
<%-- 						</c:forEach> --%>
						<tr>
							<th><label for="tendereco">Endereço:</label></th>
							<td><input id="tendereco" name="tendereco" type="text" value="${user.pessoa.endereco.endereco }" /></td>
						</tr>
						<tr>
							<th><label for="tnum">Numero:</label></th>
							<td><input id="tnum" name="tnum" type="text" value="${user.pessoa.endereco.numero }" /></td>
						</tr>
						<tr>
							<th><label for="tcomp">Complemento:</label></th>
							<td><input id="tcomp" name="tcomp" type="text" value="${user.pessoa.endereco.complemento }" /></td>
						</tr>
						<tr>
							<th><label for="tbairro">Bairro:</label></th>
							<td><input id="tbairro" name="tbairro" type="text" value="${user.pessoa.endereco.bairro }" /></td>
						</tr>
						<tr>
							<th><label for="tcidade">Cidade:</label></th>
							<td><input id="tcidade" name="tcidade" type="text" value="${user.pessoa.endereco.cidade }" /></td>
						</tr>
						<tr>
							<th><label for="testado">Estado:</label></th>
							<td><input id="testado" name="testado" type="text" value="${user.pessoa.endereco.estado }" /></td>
						</tr>
						<tr>
							<th><label for="tcep">CEP:</label></th>
							<td><input id="tcep" name="tcep" type="text" value="${user.pessoa.endereco.cep }" /></td>
						</tr>
						<tr><td>&nbsp; <input name="con" type="hidden" value="ok" /> </td></tr>
						<tr><td colspan="2"><hr></td></tr>
						<tr>
							<td colspan="2"><input type="submit" value="Salvar" /> 
							<input type="reset" value="Desfazer" /> 
							<input type="button" value="Cancelar" onclick="javascript:window.location = '${initParam['raiz'] }/pages/meusDados.jsp'" /></td>
						</tr>
					</table>
					</c:if>
					</form>
				</c:if>
				
				
			</div>
		</div>
	</main:MainLayout>
</main:body>