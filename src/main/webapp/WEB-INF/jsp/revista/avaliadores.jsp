<head>
	<title>Avaliadores da Revista</title>
</head>
<body>
	<h1>Avaliadores da Revista ${revista.id}</h1>
	
	<table>
		<tr>
			<th><fmt:message key="avaliador.id"/></th>
			<th><fmt:message key="avaliador.nome"/></th>
			<th></th>
		</tr>

		<c:forEach items="${avaliadorList}" var="avaliador">
			<tr>
				<td>${avaliador.id}</td>
				<td>${avaliador.autor.nome} </td>
				
				<td>
					<form action="${linkTo[RevistaController].removerAvaliador[revista][avaliador]}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="${linkTo[RevistaController].newAvaliador[revista]}">New Avaliador</a> 
</body>