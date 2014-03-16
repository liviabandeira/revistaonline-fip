<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ page language="java" contentType="text/html; text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head> 
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Revista FIP Online" />
    <meta name="author" content="Marcos Filho"/>

    <title>Revista FIP Online</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" />
    
    <!-- Add custom CSS here -->
    <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    
    <decorator:head/>    
  </head>
  <body>
	<div id="erros">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.category } - ${error.message }</li>
<%-- 				<li>${error.message}</li> --%>
			</c:forEach>
		</ul>
	</div>
	
  	<div id="tudo">
		<jsp:include page="../includes/header.jsp" />
		<div style="clear: both;"></div>
  		<div class="container" style="margin-top: 30px;">
  			
			<jsp:include page="../includes/scripts.jsp" />

			<!-- Paginas com os messages -->
			<%-- <jsp:include page="../includes/messages.jsp" /> --%>
			<!-- CONTEUDO -->
			<decorator:body />

			<jsp:include page="../includes/footer.jsp" />
		</div>
	</div>
</body>
</html>
