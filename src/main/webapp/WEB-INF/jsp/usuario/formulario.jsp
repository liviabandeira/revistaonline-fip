<div>
	<form action="${linkTo[UsuarioController].salvar}" method="POST">
		<fieldset>
			<legend>Novo Usuário</legend>
			<jsp:include page="_form.jsp"/>
			<button type="submit" class="btn btn-default">Salvar</button>
		</fieldset>
	</form>

</div>