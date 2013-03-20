<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="main" tagdir="/WEB-INF/tags"%>

<main:body titlePage="Bem Vindo!">
	<main:MainLayout>
		<div id="content">
			<main:Menu />
			<div id="right">
				<img src="${initParam['raiz'] }/img/destaque.jpg" />
				<main:ProdutosDestaques quant="4" />
			</div>
		</div>
	</main:MainLayout>
</main:body>