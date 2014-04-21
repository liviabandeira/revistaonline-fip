<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Avaliadores</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form action="${linkTo[RevistaController].buscarAvaliador[revista]}"
					method="get">
					<div class="row">
						<div class="form-group col-lg-4">
							<label><fmt:message key="autor.nome" />:</label> <input
								type="text" class="form-control" name="nome"
								placeholder='<fmt:message key="autor.nome"/>' />
						</div>
					</div>
						<button type="submit" class="btn btn-default">
  							<span class="glyphicon glyphicon-search"></span> Buscar
						</button>
				</form>

				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="autor.nome" /></th>
							<th>Instituição</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${autorList}" var="autor">
							<tr>
								<td>${autor.id}</td>
								<td>${autor.prenome} ${autor.nome} ${autor.sobrenome}</td>
								<td>${autor.instituicao}</td>
								<td>
									<form
										action="${linkTo[RevistaController].createAvaliador[revista]}"
										method="post">
										<input type="hidden" name="autor.id" value="${autor.id}" />
										<button type="submit" class="btn btn-default btn-sm">
				  							<span class="glyphicon glyphicon-plus"></span>
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
	<div class="col-xs-12" align="left">
		<a class="btn btn-default" href="${linkTo[RevistaController].avaliadores[revista]}" title="Voltar">
			<span class="glyphicon glyphicon-chevron-left"></span>
			Voltar
		</a>
	</div>
</div>
