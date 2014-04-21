<input type="hidden" name="usuario.id" value="${usuario.id}" />

<div class="row">
	<div class="form-group col-lg-3">
		<label>E-mail:</label> <input type="text" class="form-control"
			name="usuario.email" placeholder="josedasilva@dominio.com"
			value="${usuario.email}"
			<c:if test="${action=='edit'}">readonly</c:if> />
	</div>
</div>

<div class="row">
	<div class="form-group col-lg-2">
		<label>Login:</label> <input type="text" class="form-control"
			name="usuario.login" placeholder="josedasilva"
			value="${usuario.login}"
			<c:if test="${action=='edit'}">readonly</c:if> />
	</div>
</div>

<c:if test="${action == 'new'}">
	<div class="row">
		<div class="form-group col-lg-3">
			<label>Senha:</label> <input type="password" class="form-control"
				name="usuario.senha" placeholder="Senha" value="" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-3">
			<label>Repetir Senha:</label> <input type="password"
				class="form-control" name="usuario.confirmacaoSenha"
				placeholder="Repetir Senha" value="" />
		</div>
	</div>
</c:if>

<ul id="cadastro" class="nav nav-tabs">
	<li class="active"><a href="#dadospessoais" data-toggle="tab">Dados
			Pessoais</a></li>
	<li><a href="#dadosprofissionais" data-toggle="tab">Dados
			Profissionais</a></li>
</ul>

<div class="tab-content">
	<div class="tab-pane fade in active" id="dadospessoais">

		<div class="row">
			<div class="form-group col-lg-1">
				<label>Titulação:</label> <select class="form-control"
					name="autor.titulacao">
					<option></option>
					<option value="ESP"
						<c:if test="${autor.titulacao == 'ESP'}">selected</c:if>>Esp.</option>
					<option value="MS"
						<c:if test="${autor.titulacao == 'MS'}">selected</c:if>>Ms.</option>
					<option value="DR"
						<c:if test="${autor.titulacao == 'DR'}">selected</c:if>>Dr.</option>
				</select>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-3">
				<label>Prenome:</label> <input type="text" class="form-control"
					name="autor.prenome" placeholder="José" value="${autor.prenome}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-3">
				<label>Nome:</label> <input type="text" class="form-control"
					name="autor.nome" placeholder="Carlos" value="${autor.nome}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-3">
				<label>Sobrenome:</label> <input type="text" class="form-control"
					name="autor.sobrenome" placeholder="da Silva"
					value="${autor.sobrenome}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-1">
				<label>Inciais:</label> <input type="text" class="form-control"
					name="autor.iniciais" placeholder="JCS" value="${autor.iniciais}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-2">
				<label>Sexo:</label> <select class="form-control" name="autor.sexo">
					<option></option>
					<option value="M" <c:if test="${autor.sexo == 'M'}">selected</c:if>>M</option>
					<option value="F" <c:if test="${autor.sexo == 'F'}">selected</c:if>>F</option>
					<option value="O" <c:if test="${autor.sexo == 'O'}">selected</c:if>>Outro</option>
				</select>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-2">
				<label>Fone:</label> <input type="text" class="form-control phone_with_ddd"
					name="autor.fone" placeholder="(000) 1234-5678" value="${autor.fone}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-2">
				<label>Celular:</label> <input type="text" class="form-control phone_with_ddd"
					name="autor.celular" placeholder="(000) 1234-5678"
					value="${autor.celular}" />
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-lg-3">
				<label>Assinatura:</label>
				<textarea rows="4" cols="50" class="form-control"
					name="autor.assinatura" placeholder="José Carlos da Silva.">${autor.assinatura}</textarea>
			</div>
		</div>

	</div>

	<div class="tab-pane fade" id="dadosprofissionais">



		<div class="row">
			<div class="form-group col-lg-4">
				<label>Instituição:</label> <input type="text" class="form-control"
					name="autor.instituicao"
					placeholder="Universidade Federal de Pernambuco"
					value="${autor.instituicao}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-4">
				<label>Lattes:</label> <input type="text" class="form-control"
					name="autor.lattes"
					placeholder="http://lattes.cnpq.br/9999999999999999"
					value="${autor.lattes}" />
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-3">
				<label>Endereço Postal:</label>
				<textarea rows="4" cols="50" class="form-control"
					name="autor.enderecoPostal"
					placeholder="Rua, Ayrton Senna, 123, Brasil">${autor.enderecoPostal}</textarea>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-3">
				<label>Resumo da Biografia:</label>
				<textarea rows="4" cols="50" class="form-control"
					name="autor.resumoBiografia" placeholder="Departamento, Área">${autor.resumoBiografia}</textarea>
			</div>
		</div>

	</div>
</div>
