<div style="width:800px; margin:0 auto;">
	<form action="${linkTo[LoginController].auth}" method="post">
	    <fmt:message key="app.login" /> <input type="text" name="usuario.login"/>
	    <fmt:message key="app.senha"/> <input type="password" name="usuario.senha"/>
	    <input type="submit" value='<fmt:message key="botao.entrar"/>'>
	    <a href="${linkTo[LoginController].username}">Esqueceu sua senha?</a>
	</form>
	
</div>
