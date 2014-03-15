<head>
	<title>Revista [index]</title>
</head>
<body>
	<h1>Listing Revista</h1>
	
	<table>
		<tr>
			<th><fmt:message key="revista.id"/></th>
			<th><fmt:message key="revista.issn"/></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${revistaList}" var="revista">
			<tr>
				<td>${revista.id}</td>
				<td>${revista.issn}</td>
				<td><a href="${linkTo[RevistaController].show[revista]}">show</a> |</td>
				<td><a href="${linkTo[RevistaController].edit[revista]}">edit</a> |</td>
				
				<td>
					<form action="${linkTo[RevistaController].destroy[revista]}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="${linkTo[RevistaController].newRevista}">New Revista</a> 
</body>