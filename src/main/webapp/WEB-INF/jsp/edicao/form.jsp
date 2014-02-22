<form action="${linkTo[EdicaoController].update}" method="post">

	<c:if test="${not empty edicao.id}">
		<input type="hidden" name="edicao.id" value="${edicao.id}" />
		<input type="hidden" name="_method" value="put" />
	</c:if>

	<div class="row">
		<div class="form-group col-lg-3">
			<label><fmt:message key="edicao.volume"/></label>
			<input type="text" class="form-control" name="edicao.volume" placeholder='<fmt:message key="edicao.volume"/>' value="${edicao.volume}" />
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-lg-3">
			<label><fmt:message key="edicao.numero"/></label>
			<input type="text" class="form-control" name="edicao.numero" placeholder='<fmt:message key="edicao.numero"/>' value="${edicao.numero}" />
		</div>
	</div>

	<div class="actions">
		<input type="submit" value='<fmt:message key="botao.enviar"/>'>
	</div>
</form>

<a href="${linkTo[EdicaoController].index}">Back</a>
