<fieldset>
     <legend>Listar Usuários</legend>

<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Nome</th>
			<th>E-Mail</th>
			<th>Login</th>
			<c:if test="${usuarioLogado.admin}">
				<th>Admin</th>
			</c:if>
			<th>Editar</th>
			<th>Excluir</th>
			<th>Alterar Senha</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${usuarioList}" var="usuario">
		<tr>
			<td>${usuario.id}</td>
			<td>${usuario.nome}</td>
			<td>${usuario.email}</td>
			<td>${usuario.login}</td>
			<c:if test="${usuarioLogado.admin}">
				<td>
					<c:choose>
						<c:when test="${usuario.admin}">
							<form action="${linkTo[UsuarioController].addRoleAdmin[usuario]}" method="POST">
								<button id="btn_admin_ok" class="btn btn-default" rel="tooltip" data-placement="right" title="Remover administrador" name="_method" value="DELETE">
									<span class="glyphicon glyphicon-ok"></span>
								</button>
							</form>
						</c:when>
						<c:when test="${!usuario.admin}">
							<form action="${linkTo[UsuarioController].delRoleAdmin[usuario]}" method="POST">
								<button id="btn_admin_remove" class="btn btn-default" rel="tooltip" data-placement="right" title="Tornar administrador" name="_method" value="PUT">
									<span class="glyphicon glyphicon-remove"></span>
								</button>
							</form>
						</c:when>
					</c:choose>
				</td>
			</c:if>
			<td>
				<a class="btn btn-default" href="${linkTo[UsuarioController].editar[usuario]}">
					<span class="glyphicon glyphicon-edit"></span>
				</a>
			</td>
			<td>
				<form action="${linkTo[UsuarioController].excluir[usuario]}" method="POST">
					<button class="btn btn-default" name="_method" value="DELETE">
						<span class="glyphicon glyphicon-remove-circle"></span>
					</button>
				</form>
			</td>
			<td>
				<a class="btn btn-default" href="${linkTo[UsuarioController].alterarSenha[usuario]}">
					<span class="glyphicon glyphicon-edit"></span>
				</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</fieldset>
<script>
	$("#btn_admin_ok").tooltip();
	$("#btn_admin_remove").tooltip();
    
    $("#btn_admin_ok").mouseover(function() {
    	$(this).find("span").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-minus");
    });
    
    $("#btn_admin_ok").mouseout(function() {
    	$(this).find("span").removeClass("glyphicon glyphicon-minus").addClass("glyphicon glyphicon-ok");
    });
    
    $("#btn_admin_remove").mouseover(function() {
    	$(this).find("span").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-plus");
    });
    
    $("#btn_admin_remove").mouseout(function() {
    	$(this).find("span").removeClass("glyphicon glyphicon-plus").addClass("glyphicon glyphicon-remove");
    });
</script>