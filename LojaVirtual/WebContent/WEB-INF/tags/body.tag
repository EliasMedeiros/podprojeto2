<%@ tag body-content="scriptless" %>

<%@ attribute name="titlePage" required="true" rtexprvalue="false" description="Atributo com o nome que vai ficar no title da página" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${initParam['raiz'] }/css/estilo.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script src="${initParam['raiz'] }/js/functions.js" type="text/javascript"> </script>
		<title>Livraria PWeb - ${titlePage }</title>
	</head>
	
	<body>
	
	<jsp:doBody />
	
	</body>
	
</html>
