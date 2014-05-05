<div>
	<form action="${linkTo[LoginController].esqueciminhaSenha[usuario.token]}" method="POST">
		<fieldset>
			<legend>Alterar senha</legend>
			<input type="hidden" name="usuario.token" value="${usuario.token}" /> 
			Digite sua senha:  <input type="password" name="novaSenha"/><br>
			Confirme sua nova senha:  <input type="password" name="confirmacao"/><br>
			<button type="submit" class="btn btn-default">Enviar</button>
		</fieldset>
	</form>
</div>