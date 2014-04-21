<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Revistas</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Título</th>
								<th>Edição Atual</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${revistaList}" var="revista">
								<tr>
									<td>${revista.id}</td>
									<td>${revista.titulo}</td>
									<td>
										<c:if test="${not empty revista.edicoes}">${revista.edicoes[0].volume}/${revista.edicoes[0].numero}</c:if>
										<c:if test="${empty revista.edicoes}">Nenhuma</c:if>
									</td>
									<td>
										<a class="btn btn-default btn-sm" href="${linkTo[RevistaController].show[revista]}" title="Editar Revista">
											<span class="glyphicon glyphicon-search"></span>
										</a>
										<a class="btn btn-default btn-sm" href="${linkTo[EdicaoController].newEdicao[revista]}" title="Nova Edição">
											<span class="glyphicon glyphicon-file"></span>
										</a>
										<a class="btn btn-default btn-sm" href="${linkTo[RevistaController].avaliadores[revista]}" title="Gerenciar Revisores">
											<span class="glyphicon glyphicon-user"></span>
										</a>
										<button type="button" class="btn btn-default btn-sm" title="Distribuir Artigos para Avaliação">
											<span class="glyphicon glyphicon-share"></span>
										</button>
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
		<a class="btn btn-default" href="${linkTo[RevistaController].newRevista}" title="Nova Revista">
			<span class="glyphicon glyphicon-plus"></span>
			Revista
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