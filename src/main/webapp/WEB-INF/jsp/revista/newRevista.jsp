<div class="row">
	<!-- /.col-lg-12 -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Nova Revista</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div>

					<form action="${linkTo[RevistaController].create}" method="post">
						<%@include file="form.jsp"%>
						<div class="actions">
							<a href="${linkTo[OfficeController].revistas}" class="btn btn-default">Voltar</a> 
							<input type="submit" class="btn btn-default" value='<fmt:message key="botao.salvar"/>'>
						</div>
					</form>

				</div>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
