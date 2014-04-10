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
								<th>Título</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
								<td>
									<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/revista/1/edit" title="Editar Revista">
										<span class="glyphicon glyphicon-pencil"></span>
									</a>
									<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/edicao/new" title="Nova Edição">
										<span class="glyphicon glyphicon-file"></span>
									</a>
									<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/revista/1/avaliadores" title="Gerenciar Revisores">
										<span class="glyphicon glyphicon-user"></span>
									</a>
									<button type="button" class="btn btn-default btn-sm" title="Distribuir Artigos para Avaliação">
										<span class="glyphicon glyphicon-share"></span>
									</button>
								</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
								<td>
									<a href="revista/1/edit">
										<button type="button" class="btn btn-default btn-sm" title="Editar Revista">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
									</a>
									<button type="button" class="btn btn-default btn-sm" title="Nova Edição">
										<span class="glyphicon glyphicon-file"></span>
									</button>
									<button type="button" class="btn btn-default btn-sm" title="Gerenciar Revisores">
										<span class="glyphicon glyphicon-user"></span>
									</button>
									<button type="button" class="btn btn-default btn-sm" title="Distribuir Artigos para Avaliação">
										<span class="glyphicon glyphicon-share"></span>
									</button>
								</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
								<td>
									<button type="button" class="btn btn-default btn-sm" title="Editar Revista">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
									<button type="button" class="btn btn-default btn-sm" title="Nova Edição">
										<span class="glyphicon glyphicon-file"></span>
									</button>
									<button type="button" class="btn btn-default btn-sm" title="Gerenciar Revisores">
										<span class="glyphicon glyphicon-user"></span>
									</button>
									<button type="button" class="btn btn-default btn-sm" title="Distribuir Artigos para Avaliação">
										<span class="glyphicon glyphicon-share"></span>
									</button>
								</td>
							</tr>
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
</div>
<!-- /.row -->
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
	<div class="col-xs-12" align="right">
		<a class="btn btn-default" href="${pageContext.request.contextPath}/revista/new" title="Nova Revista">
			<span class="glyphicon glyphicon-plus"></span>
			Revista
		</a>
	</div>
</div>