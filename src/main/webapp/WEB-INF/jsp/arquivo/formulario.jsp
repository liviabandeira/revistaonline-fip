<form action="<c:url value="/upload/file"/>" method="POST" enctype="multipart/form-data">
	<fieldset>
		<legend>Upload de arquivo</legend>
		<div class="form-group" >
			<a class="btn btn-primary btn-file">
				Selecione o arquivo<input id="file" type="file" name="file" />		
			</a>
		</div>
		<button type="submit" class="btn btn-default">Enviar</button>
	</fieldset>
</form>