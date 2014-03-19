<div>
	<form action="${linkTo[UsuarioController].atualizarSenha[usuario]}" method="POST">
		<fieldset>
			<legend>Alterar senha</legend>
			Senha Atual:   <input type="password" name="senhaAtual"><br>
			Nova Senha: <input type="password" name="novaSenha"><br>
			<p>Insira no minimo 8 caracteres</p>
			Repetir nova senha: <input type="password" name="novaSenha"><br>
			<button type="submit" name="_method" value="PUT" class="btn btn-default">Salvar</button>
		</fieldset>
	</form>

</div>