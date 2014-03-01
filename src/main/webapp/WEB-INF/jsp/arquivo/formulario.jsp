<html>
<head>
<title>Upload de arquivos</title>
</head>
<body>
	<form action="<c:url value="/upload/file"/>" method="POST"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Upload de arquivo</legend>
			<input id="file" input type="file" name="file" />
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
</html>