<head>
	<title>Add Avaliador</title>
</head>
<body>
	
	<form action="${linkTo[RevistaController].buscarAvaliador[revista]}" method="get">
		<div class="row">
			<div class="form-group col-lg-3">
				<label><fmt:message key="autor.nome"/></label>
				<input type="text" class="form-control" name="nome" placeholder='<fmt:message key="autor.nome"/>' />
			</div>
		</div>
		<button type="submit">Buscar</button>
	</form>
	
	<table>
		<tr>
			<th><fmt:message key="autor.id"/></th>
			<th><fmt:message key="autor.nome"/></th>
			<th></th>
		</tr>

		<c:forEach items="${autorList}" var="autor">
			<tr>
				<td>${autor.id}</td>
				<td>${autor.nome} </td>
				<td>
					<form action="${linkTo[RevistaController].createAvaliador[revista]}" method="post">
						<input type="hidden" name="autor.id" value="${autor.id}" />
						<button type="submit">adicionar</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>