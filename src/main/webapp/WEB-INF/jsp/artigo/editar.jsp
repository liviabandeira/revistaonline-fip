<div>
	<form action="${linkTo[ArtigoController].atualizar[artigo]}" method="POST">
		<fieldset>
			<legend>Editar Artigo</legend>
			<jsp:include page="submissao.jsp"/>
			<button type="submit" name="_method" value="PUT" class="btn btn-default">Salvar</button>
		</fieldset>
	</form>

</div>