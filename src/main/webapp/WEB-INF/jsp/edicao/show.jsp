<head>
	<title>Edicao [show]</title>
</head>
<body>
	<p>
		<b><fmt:message key="edicao.volume"/></b>
		${edicao.volume}
	</p>
	
	<p>
		<b><fmt:message key="edicao.numero"/></b>
		${edicao.numero}
	</p>

	<a href="${linkTo[EdicaoController].edit[edicao]}">Edit</a>
	<a href="${linkTo[EdicaoController].index}">Back</a>
</body>