<input type="hidden" name="usuario.id" value="${usuario.id}" />
<input type="hidden" name="usuario.status" value="${usuario.status}" />
<input type="hidden" name="usuario.dtaCadastro" value="<fmt:formatDate value="${usuario.dtaCadastro}" pattern="dd/MM/yyyy" />" />
<input type="hidden" name="usuario.dtaUltimoAcesso" value="<fmt:formatDate value="${usuario.dtaUltimoAcesso}" pattern="dd/MM/yyyy" />" />
<input type="hidden" name="usuario.tentativasLogon" value="${usuario.tentativasLogon}" />
<input type="hidden" name="usuario.alterarSenhaProximoAcesso" value="${usuario.alterarSenhaProximoAcesso}" />

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>E-mail:</label>
		<input type="text" class="form-control" name="usuario.email" placeholder="josedasilva@dominio.com" value="${usuario.email}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-2" >
		<label>Login:</label>
		<input type="text" class="form-control" name="usuario.login" placeholder="josedasilva" value="${usuario.login}" />
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
		<label>Repetir Senha:</label>
		<input type="password" class="form-control" name="usuario.confirmacaoSenha" placeholder="Repetir Senha" value="" />
	</div>	
</div>

<div class="row" >
	<div class="form-group col-lg-1" >
		<label>Titulação:</label>
		<select class="form-control" name="autor.titulacao" value="${autor.titulacao}">
			<option value="0"></option>
			<option value="ESP">Esp.</option>
			<option value="MS">Ms.</option>
			<option value="DR">Dr.</option>
		</select>
	</div>	
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Prenome:</label>
		<input type="text" class="form-control" name="autor.prenome" placeholder="José" value="${autor.prenome}" />
	</div>	
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Nome:</label>
		<input type="text" class="form-control" name="autor.nome" placeholder="Carlos" value="${autor.nome}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Sobrenome:</label>
		<input type="text" class="form-control" name="autor.sobrenome" placeholder="da Silva" value="${autor.sobrenome}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-1" >
		<label>Inciais:</label>
		<input type="text" class="form-control" name="autor.iniciais" placeholder="JCS" value="${autor.iniciais}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-1" >
		<label>Sexo:</label>
		<select class="form-control" name="autor.sexo" value="${autor.sexo}">
			<option value="0"></option>
			<option value="M">M</option>
			<option value="F">F</option>
			<option value="O">Outro</option>
		</select>
	</div>	
</div>

<div class="row" >
	<div class="form-group col-lg-4" >
		<label>Instituição:</label>
		<input type="text" class="form-control" name="autor.instituicao" placeholder="Universidade Federal de Pernambuco" value="${autor.instituicao}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Assinatura:</label>
		<textarea rows="4" cols="50" class="form-control" name="autor.assinatura" placeholder="Assinatura">${autor.assinatura}</textarea>
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-4" >
		<label>Lattes:</label>
		<input type="text" class="form-control" name="autor.lattes" placeholder="http://lattes.cnpq.br/9999999999999999" value="${autor.lattes}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-2" >
		<label>Fone:</label>
		<input type="text" class="form-control" name="autor.fone" placeholder="00012345678" value="${autor.fone}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-2" >
		<label>Celular:</label>
		<input type="text" class="form-control" name="autor.celular" placeholder="00012345678" value="${autor.celular}" />
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Endereço Postal:</label>
		<textarea rows="4" cols="50" class="form-control" name="autor.enderecoPostal" placeholder="Rua, Ayrton Senna, 123, Brasil">${autor.enderecoPostal}</textarea>
	</div>
</div>

<div class="row" >
	<div class="form-group col-lg-3" >
		<label>Resumo da Biografia:</label>
		<textarea rows="4" cols="50" class="form-control" name="autor.resumoBiografia" placeholder="Departamento, Área">${autor.resumoBiografia}</textarea>
	</div>
</div>
