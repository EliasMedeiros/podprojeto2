<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main:body titlePage="Cadastro de usuário">
	<main:MainLayout>
		<div id="content">
			<main:Menu />

			<div id="right">
				<c:if test="${user ne null }">
					<c:redirect url="/pages/meusDados.jsp"></c:redirect>
				</c:if>
				<form method="POST" action="${initParam['raiz'] }/cadastrar">
					<h3>Dados do Usuário</h3>
					<c:if test="${msgErroCadastrar ne null }"><center><span class="erroMsg">${msgErroCadastrar }</span></center><br /></c:if>
					<table cellspacing="3" id="tabelaMeusDados">
						<tr>
							<th><label for="clogin"><span class="warning">* </span>Login:</label></th>
							<td><input id="clogin" name="clogin" type="text" maxlength="15" value="${clogin}"/></td>
						</tr>
						<tr>
							<th><label for="cpass"><span class="warning">* </span>Senha:</label></th>
							<td><input id="cpass" name="cpass" type="password" maxlength="20" /></td>
							<th><label for="cpass2"><span class="warning">* </span>Repetir Senha:</label></th>
							<td><input id="cpass2" name="cpass2" type="password" maxlength="20" /></td>
						</tr>
						<tr>
							<th><label for="cemail"><span class="warning">* </span>E-Mail:</label></th>
							<td><input id="cemail" name="cemail" type="text" size="30" value="${cemail}"/></td>
						</tr>
						<tr>
							<td colspan="4"><hr /></td>
						</tr>
					</table>
					<h3>Dados Pessoais</h3>
					<table cellspacing="3" id="tabelaMeusDados">
						<tr>
							<th><label for="cnome"><span class="warning">* </span>Nome:</label></th>
							<td><input id="cnome" name="cnome" type="text" value="${cnome}"/></td>
						</tr>
						<tr>
							<th><label for="ccpf"><span class="warning">* </span>CPF:</label></th>
							<td><input id="ccpf" name="ccpf" type="text" value="${ccpf}" /></td>
						</tr>
						<tr>
							<th><label for="crg"><span class="warning">* </span>RG:</label></th>
							<td><input id="crg" name="crg" type="text" value="${crg}" /></td>
						</tr>
						<tr>
							<th><label for="cdata"><span class="warning">* </span>Data de Nascimento: </label></th>
							<td>
								<input id="cdata" name="cdataDia" type="text" size="2" maxlength="2" value="${cdataDia}" /> 
								<select name="cdataMes">
									<option>Mês...</option>
									<c:forEach var="mes" items="${meses }" varStatus="valor">
									<option value="${valor.index }" 
										<c:if test="${valor.index eq cdataMes}">
	                                        selected									   
										</c:if>
									>${mes }</option>
									</c:forEach>
								</select> 
								<input name="cdataAno" type="text" size="4" maxlength="4" value="${cdataAno}" />
							</td>
						</tr>
						<tr>
							<th><label for="cendereco"><span class="warning">* </span>Endereço:</label></th>
							<td><input id="cendereco" name="cendereco" type="text" size="35" value="${cendereco}" /></td>
							<th><label for="cnum"><span class="warning">* </span>Número:</label></th>
							<td><input id="cnum" name="cnum" type="text" size="5" value="${cnum}" /></td>
						</tr>
						<tr>
							<th><label for="cbairro"><span class="warning">* </span>Bairro:</label></th>
							<td><input id="cbairro" name="cbairro" type="text" size="35" value="${cbairro}" /></td>
						</tr>
						<tr>
							<th><label for="ccomp">Complemento:</label></th>
							<td><input id="ccomp" name="ccomp" type="text" value="${ccomp}" /></td>
							<th><label for="ccep"><span class="warning">* </span>CEP:</label></th>
							<td><input id="ccep" name="ccep" type="text" value="${ccep}" /></td>
						</tr>
						<tr>
							<th><label for="ccidade"><span class="warning">* </span>Cidade:</label></th>
							<td><input id="ccidade" name="ccidade" type="text" value="${ccidade}" /></td>
							<th><label for="cestado"><span class="warning">* </span>Estado:</label></th>
							<td><input id="cestado" name="cestado" type="text" value="${cestado}" /></td>
						</tr>
						<tr>
							<th><label for="ctelcel"><span class="warning">* </span>Telefone Celular:</label></th>
							<td><input id="ctelcel" name="ctelcel" type="text" value="${ctelcel}" /></td>
						</tr>
						<tr>
							<th><label for="ctelres">Telefone Residencial:</label></th>
							<td><input id="ctelres" name="ctelres" type="text" value="${ctelres}" /></td>
						</tr>
						<tr>
							<th><label for="ctelcom">Telefone Comercial:</label></th>
							<td><input id="ctelcom" name="ctelcom" type="text" value="${ctelcom}" /></td>
						</tr>
						<tr><td colspan="4"><hr></td></tr>
						<tr><td><span class="warning">* Campos Obrigatórios.</span></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td colspan="2"><input type="submit" value="Salvar" /> 
							<input type="reset" value="Apagar" /> 
							<input type="button" value="Cancelar" onclick="javascript:window.location = '${initParam['raiz'] }/pages/meusDados.jsp'" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</main:MainLayout>
</main:body>