<div>
	<form action="${linkTo[LoginController].enviarEmail}" method="POST">
		<fieldset>
			<legend>Alterar senha</legend>
			<input type="hidden" name="usuario.username" value="${usuario.username}" /> 
			Informe seu username:  <input type="text" name="username"/><br>
			<button type="submit" class="btn btn-default">Enviar</button>
		</fieldset>
	</form>
</div>