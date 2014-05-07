<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Revisões Pendentes</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Artigo</th>
								<th>Revista</th>
								<th>Data de Submissão</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${avaliacaoList}" var="avaliacao">
							<tr>
								<tr>
								<td>${avaliacao.id}</td>
								<td>${avaliacao.artigo.titulo}</td>
								<td>${avaliacao.artigo.revista.titulo}</td>				
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${avaliacao.artigo.dataSubmissao.time}"/></td>
								<td>
									<a class="btn btn-default btn-sm" href="${linkTo[AvaliacaoController].formAvaliacao[avaliacao]}" title="Avaliar">
										<span class="glyphicon glyphicon-pencil"></span>
									</a>
									<a class="btn btn-default btn-sm" href="#" title="Baixar o Artigo">
										<span class="glyphicon glyphicon-cloud-download"></span>
									</a>
								</td>
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
</div>