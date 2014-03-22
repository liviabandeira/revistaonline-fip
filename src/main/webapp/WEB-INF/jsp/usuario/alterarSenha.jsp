
<div>
	<form action="${linkTo[UsuarioController].atualizarSenha}" method="POST">
		<fieldset>
			<legend>Alterar senha</legend>
			 <input type="hidden" name="usuario.id" value="${usuario.id}" /> 
			Senha Atual:  <input type="password" name="senhaAtual"/><br>
			Nova Senha:  <input type="password" name="novaSenha"/><br>
			<p>Insira no minimo 5 caracteres, contendo letras maiusculas, minusculas e numeros</p>
			Repetir nova senha: <input type="password" name="confirmacao"/>
			<button type="submit" class="btn btn-default">Salvar</button>
		</fieldset>
	</form>

</div>