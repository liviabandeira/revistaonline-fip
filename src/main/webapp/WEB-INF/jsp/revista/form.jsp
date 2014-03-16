<form action="${linkTo[RevistaController].update}" method="post">

	<c:if test="${not empty revista.id}">
		<input type="hidden" name="revista.id" value="${revista.id}" />
		<input type="hidden" name="_method" value="put" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-3">
			<label><fmt:message key="revista.issn"/></label>
			<input type="text" class="form-control" name="revista.issn" placeholder='<fmt:message key="revista.issn"/>' value="${revista.issn}" />
		</div>
	</div>
	
	<div class="actions">
		<input type="submit" value='<fmt:message key="botao.enviar"/>'>
	</div>
</form>

<a href="${linkTo[RevistaController].index}">Back</a>
