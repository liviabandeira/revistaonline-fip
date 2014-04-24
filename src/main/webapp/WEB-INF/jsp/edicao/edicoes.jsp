<div class="container">

	<div class="row">

		<div class="col-lg-12">
			<h1 class="page-header">
				${revista} <small>Edições</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/">Home</a></li>
				<li><a href="${linkTo[RevistaController].revistas}">Revistas</a>
				<li class="active">Edicoes</li>
			</ol>
		</div>

	</div>

	<div class="row">

		<c:forEach items="${edicaoList}" var="edicao">
			<div class="col-md-6 portfolio-item">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/750x450">
					<!-- http://placehold.it/750x450 -->
					<!-- ${pageContext.request.contextPath}/capasedicao/${edicao.id}.jpg -->
				</a>
				<h3>
					<a href="#">Edição: ${edicao.numero}</a>
				</h3>
				<p>Volume: ${edicao.volume}</p>
			</div>
		</c:forEach>

	</div>


</div>