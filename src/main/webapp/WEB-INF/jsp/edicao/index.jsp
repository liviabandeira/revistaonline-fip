<head>
	<title>Edicao [index]</title>
</head>
<body>
	<h1>Listing Edicoes</h1>
	
	<table>
		<tr>
			<th><fmt:message key="edicao.id"/></th>
			<th><fmt:message key="edicao.volume"/></th>
			<th><fmt:message key="edicao.numero"/></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${edicaoList}" var="edicao">
			<tr>
				<td>${edicao.id}</td>
				<td>${edicao.volume}</td>
				<td>${edicao.numero}</td>
				<td><a href="${linkTo[EdicaoController].show[edicao]}">show</a> |</td>
				<td><a href="${linkTo[EdicaoController].edit[edicao]}">edit</a> |</td>
				
				<td>
					<form action="${linkTo[EdicaoController].destroy[edicao]}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="${linkTo[EdicaoController].newEdicao}">New Edicao</a> 
</body>