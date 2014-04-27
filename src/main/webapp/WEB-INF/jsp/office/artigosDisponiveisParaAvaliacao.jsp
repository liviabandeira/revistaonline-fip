<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Artigos Pendentes de Avaliação</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Título</th>
								<th>Data da Submissão</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${artigosList}" var="artigo">
								<tr>
									<td>${artigo.id}</td>
									<td>${artigo.titulo}
										<input type="hidden" id="titulo_${artigo.id}" value="${artigo.titulo}">
									</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy - HH:mm:ss" value="${artigo.dataSubmissao.time}"/></td>
									<td>
										<a class="btn btn-default btn-sm openModal" href="#selectAvaliadores" title="Selecionar Avaliadores do Artigo" data-toggle="modal" data-target="#avaliadores" data-id="${artigo.id}">
											<span class="glyphicon glyphicon-user"></span>
										</a> 
										<a class="btn btn-default btn-sm" href="#" title="Excluir Artigo"> 
											<span class="glyphicon glyphicon-trash"></span>
										</a>
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

	<!-- /.col-lg-6 -->
	<div class="col-sm-12">
		<a class="btn btn-default" href="${linkTo[OfficeController].revistas}" title="Voltar"> 
			<span class="glyphicon glyphicon-chevron-left"></span> Voltar
		</a>
	</div>
</div>
<!-- /.row -->

<!-- Modal -->
<div class="modal fade" id="avaliadores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Avaliadores do Artigo</h4>
      </div>
      <div class="modal-body">
      
      	<c:if test="${not empty modalError}">
		  	<div class="alert alert-danger alert-dismissable">
		  		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				<div id="errosModal">
						<c:forEach items="${modalError}" var="error">
							<h5>${error.message}</h5>
						</c:forEach>
				</div>
			</div>
		</c:if>
      
      	<form action="${linkTo[OfficeController].associarAvaliadores}" method="POST">
      		<input type="hidden" id="revista.id" name="revista.id" value="${revista.id}" />
			<fieldset>
				<div class="row">
		        <div class="form-group col-lg-9">
					<label>Artigo:</label>
					<input type="text" class="form-control"	id="titulo_selecionado" name="tituloSelecionado" value="${tituloSelecionado}" readonly />
					<input type="hidden" id="artigo.id" name="artigo.id" value="${artigo.id}" />
				</div>
			</div>
			
	        <div class="row">
		        <div class="form-group col-lg-8">
					<label>Avaliador 1: *</label> 
					<select class="form-control" id="avaliadores[0].id" name="avaliadores[0].id">
						<option value="-1">Selecione o avaliador 1</option>
						<c:forEach items="${avaliadores}" var="avaliador">
							<option value="${avaliador.id}">${avaliador.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
	        
	        <div class="row">
		        <div class="form-group col-lg-8">
					<label>Avaliador 2: *</label> 
					<select class="form-control" id="avaliadores[1].id" name="avaliadores[1].id">
						<option value="-1">Selecione o avaliador 2</option>
						<c:forEach items="${avaliadores}" var="avaliador">
							<option value="${avaliador.id}">${avaliador.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
	        <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		        <button type="submit" class="btn btn-primary">Salvar</button>
		    </div>
			</fieldset>
		</form>
	   </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	var errosModal = $("#errosModal");
	if(errosModal.length > 0) {
		$("#avaliadores").modal("show");
	} else {
		$(document).on("click", ".openModal", function (e) {
		    e.preventDefault();
		    var _self = $(this);
		
		    var artigoId = _self.data('id');
		    var artigoSelecionado = $("#titulo_" + artigoId).val();
		    $("#titulo_selecionado").val(artigoSelecionado);
		    $("#artigo\\.id").val(artigoId);
		
		    $("#avaliadores\\[0\\]\\.id").val('-1');
		    $("#avaliadores\\[1\\]\\.id").val('-1');
		});
	}
</script>

