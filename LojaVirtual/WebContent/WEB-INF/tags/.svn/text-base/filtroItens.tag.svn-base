<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ tag body-content="empty"%>

<div id="filtroItens">

	<div id="filtroLeft">
		Itens por Página:&nbsp;
		<select id="quantPerPage"
			onchange="javascript:window.location = '${initParam['raiz'] }/produtos?categoria=${param.categoria }&page=1&show='+this.value+'&orderBy=${param.orderBy }'">
			
			<c:forEach begin="8" end="24" step="4" varStatus="status">
			
				<c:if test="${param.show eq status.current }">
					<option value="${status.current }" selected="selected">${status.current }</option>
				</c:if>
				
				<c:if test="${param.show ne status.current }">
					<option value="${status.current }">${status.current }</option>
				</c:if>
				
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		
		Ordenar por:&nbsp;
		<select id="orderBy" 
			onchange="javascript:window.location = '${initParam['raiz'] }/produtos?categoria=${param.categoria }&page=${param.page }&show=${param.show }&orderBy='+this.value+''">
		
			<c:forEach var="select" items="${ordenacao }" step="2" varStatus="status">
				<c:if test="${param.orderBy eq select }">
					<option value="${select }" selected="selected">${ordenacao[status.index + 1] }</option>
				</c:if>
				
				<c:if test="${param.orderBy ne select }">
					<option value="${select }">${ordenacao[status.index + 1] }</option>
				</c:if>
			</c:forEach>
		
		</select>
		
	</div>
</div>