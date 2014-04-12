<script>
$(function () {
	$('#side-menu').metisMenu({
	toggle: false // disable the auto collapse. Default: true.
	});
	});
</script>

<div class="sidebar-collapse">
	<ul class="nav" id="side-menu">
		<!-- <li class="sidebar-search">
			<div class="input-group">
	          <input type="text" class="form-control" />
	         	<span class="input-group-btn">
                    <button class="btn btn-default" type="button">
                    	<i class="fa fa-search"></i>
					</button>
				</span>
	        </div>
			<div class="input-group custom-search-form">
				<input type="text" class="form-control" placeholder="Search...">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div> /input-group
		</li> -->
		<li>
			<a href="#">
				<i class="fa fa-upload fa-fw"></i>
				Novo Artigo
			</a>
		</li>
		
		<li>
			<a href="${linkTo[OfficeController].submissoes}">
				<i class="fa fa-file-text-o fa-fw"></i>
				Submissões
			</a>
		</li>
		
		<li>
			<a href="#">
				<i class="fa fa-pencil fa-fw"></i>
				Revisões
				<span class="fa arrow"></span>
			</a>
			<ul class="nav nav-second-level collapse">
				<li><a href="${linkTo[OfficeController].revisoesPendentes}">Pendentes</a></li>
				<li><a href="${linkTo[OfficeController].revisoesConcluidas}">Concluídas</a></li>
			</ul> <!-- /.nav-second-level -->
		</li>
		
		<li>
			<a href="${linkTo[OfficeController].revistas}">
				<i class="fa fa-font fa-fw"></i>
				Revistas
			</a>
		</li>
		
	</ul>
	<!-- /#side-menu -->
</div>