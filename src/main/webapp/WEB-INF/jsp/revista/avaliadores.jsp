<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Avaliadores</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th><fmt:message key="avaliador.nome"/></th>
								<th>Instituição</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${avaliadorList}" var="avaliador">
								<tr>
									<td>${avaliador.autor.id}</td>
									<td>${avaliador.autor.titulacao} ${avaliador.autor.prenome} ${avaliador.autor.nome} ${avaliador.autor.sobrenome}</td>
									<td>${avaliador.autor.instituicao}</td>
									<td>
										<form action="${linkTo[RevistaController].removerAvaliador[revista][avaliador]}" method="post">
											<input type="hidden" name="_method" value="delete"/>
											<button type="submit" onclick="return confirm('Tem certeza que deseja remover esse avaliador?')" class="btn btn-default btn-sm" title="Remover">
												<span class="glyphicon glyphicon-remove"></span>
											</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
	
	<div class="col-xs-12" align="left">
		<a class="btn btn-default" href="${linkTo[OfficeController].revistas}" title="Voltar">
			<span class="glyphicon glyphicon-chevron-left"></span>
			Voltar
		</a>
		<a class="btn btn-default" href="${linkTo[RevistaController].newAvaliador[revista]}" title="Novo Revisor">
			<span class="glyphicon glyphicon-plus"></span>
			Revisor
		</a>
	</div>
</div>
<!-- /.row -->
<!-- 
<div class="row">
	<div class="col-sm-12" align="center">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
</div> -->