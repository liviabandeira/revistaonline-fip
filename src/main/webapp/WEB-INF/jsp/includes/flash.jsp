<c:if test="${not empty errors}">
	  	<div class="alert alert-danger alert-dismissable">
	  		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<div id="erros">
				<ul>
					<c:forEach items="${errors}" var="error">
						<li>${error.category } - ${error.message}</li>
		<%-- 				<li>${error.message}</li> --%>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>
	
	<c:if test="${not empty success}">
	  	<div class="alert alert-success alert-dismissable">
	  		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<div id="success">
				<ul>
					<c:forEach items="${success}" var="msg">
						<li>${msg.message}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>