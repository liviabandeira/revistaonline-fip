<div>
	<form action="${linkTo[RevistaController].deleteNewsletter}" method="POST">
		<fieldset>
			<legend>Deixar assinatura </legend>
			<input type="hidden" name="newsletter.id" value="${newsletter.id}" />
			<input type="hidden" name="revista.id" value="${revista.id}" />
			 <p>Informe seu email para não receber informações da revista.</p> 
			 Email:  <input type="text" name="email"/><br>
			<button type="submit" class="btn btn-default">Enviar</button>
		</fieldset>
	</form>

</div>