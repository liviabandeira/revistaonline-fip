<div class="container">
	<div class="row">

		<div class="col-lg-12">
			<h1 class="page-header">
				Revistas <small>FIP - Gati</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li class="active">Revistas</li>
			</ol>
		</div>

	</div>
	<c:forEach items="${revistaList}" var="revista">
		<div class="row">

			<div class="col-md-7">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/750x350">
					<!-- http://placehold.it/750x350 -->
					<!-- ${pageContext.request.contextPath}/capasrevista/${revista.id}.jpg -->
				</a>
			</div>

			<div class="col-md-5">
				<h3>${revista.issn}</h3>
				<h4>Edições: ${fn:length(revista.edicoes)}</h4>
				<p>${revista.descricao}</p>
				<a class="btn btn-primary" href="${linkTo[EdicaoController].edicoes[revista]}">Ver Revista   
					<i class="fa fa-angle-right"></i>
				</a>
				<a class="btn btn-primary" href="${linkTo[RevistaController].assinar[revista]}">Newsletter   
					<i class="fa fa-angle-right"></i>
				</a>
			</div>

		</div>
		<hr>
	</c:forEach>
</div>