<fieldset>
     <legend>Listar Artigos</legend>

<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Título</th>
			<th>Resumo</th>
			<th>Cronologia ou Historia</th>
			<th>AreaSubArea do Conhecimento</th>
			<th>GeoEspacial</th>
			<th>Idioma</th>
			<th>Agencias</th>
			<th>Palavras Chaves</th>
			<th>Condições para Submissão</th>
			<th>Caracteristicas da Amostragem da Pesquisa</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${artigoList}" var="artigo">
		<tr>
			<td>${artigo.id}</td>
			<td>${artigo.titulo}</td>
			<td>${artigo.resumo}</td>
			<td>${artigo.cronologicaOuHistorica}</td>
			<td>${artigo.areaSubAreaDoConhecimento}</td>
			<td>${artigo.geoEspacial}</td>
			<td>${artigo.idioma}</td>
			<td>${artigo.agencias}</td>
			<td>${artigo.keyWord}</td>
			<td>${artigo.condicoesParaSubmissao}</td>
			<td>${artigo.caracteristicasDaAmostragemDaPesquisa}</td>
			<td>
				<a class="btn btn-default" href="${linkTo[ArtigoController].editar[artigo]}">
					<span class="glyphicon glyphicon-edit"></span>
				</a>
			</td>
			<td>
				<form action="${linkTo[ArtigoController].excluir[artigo]}" method="POST">
					<button class="btn btn-default" name="_method" value="DELETE">
						<span class="glyphicon glyphicon-remove-circle"></span>
					</button>
				</form>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</fieldset>