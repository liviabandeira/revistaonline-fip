<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload de Artigos</title>
</head>
<body>

<form action=
  "<c:url value="/upload/send"/>" 
  method="POST">
  <fieldset>
    <legend>Upload de Imagem</legend>
    <input type="file" name="imagem" />
    
    <button type="submit">Enviar</button>  
  </fieldset>
</form>

</body>
</html>