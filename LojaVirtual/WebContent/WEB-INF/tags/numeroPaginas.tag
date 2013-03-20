<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty" %>

	<div id="filtroPages">
		<br />Páginas: 
		<c:forEach begin="1" end="${quantPages }" varStatus="status">
		
			<c:if test="${status.current ne param.page }">
				<a href="${initParam['raiz'] }/produtos?categoria=${param.categoria }&page=${status.current }&show=${param.show }&orderBy=${param.orderBy }">${status.current }</a>
			</c:if>
			
			<c:if test="${status.current eq param.page }">
				<a class="pageAtual" href="${initParam['raiz'] }/produtos?categoria=${param.categoria }&page=${status.current }&show=${param.show }&orderBy=${param.orderBy }">${status.current }</a>
			</c:if>
			
		</c:forEach>
	</div>