<input type="hidden" name="usuario.id" value="${usuario.id}" />
<input type="hidden" name="usuario.status" value="${usuario.status}" />
<input type="hidden" name="usuario.dtaCadastro" value="<fmt:formatDate value="${usuario.dtaCadastro}" pattern="dd/MM/yyyy" />" />
<input type="hidden" name="usuario.dtaUltimoAcesso" value="<fmt:formatDate value="${usuario.dtaUltimoAcesso}" pattern="dd/MM/yyyy" />" />
<input type="hidden" name="usuario.tentativasLogon" value="${usuario.tentativasLogon}" />
<input type="hidden" name="usuario.alterarSenhaProximoAcesso" value="${usuario.alterarSenhaProximoAcesso}" />
<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Nome:</label>
		<input type="text" class="form-control" name="usuario.nome" placeholder="Nome" value="${usuario.nome}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Login:</label>
		<input type="text" class="form-control" name="usuario.login" placeholder="Login" value="${usuario.login}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Senha:</label>
		<input type="password" class="form-control" name="usuario.senha" placeholder="Senha" value="" />
	</div>	
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>CPF:</label>
		<input type="text" class="form-control" name="usuario.cpf" placeholder="CPF" value="${usuario.cpf}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>E-Mail:</label>
		<input type="text" class="form-control" name="usuario.email" placeholder="E-Mail" value="${usuario.email}" />
	</div>
</div>
