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
			<a href="#">
				<i class="fa fa-file-text-o fa-fw"></i>
				Artigos
			</a>
		</li>
		
		<li>
			<a href="#">
				<i class="fa fa-pencil fa-fw"></i>
				Revisões
			</a>
		</li>
		
		<li>
			<a href="#">
				<i class="fa fa-font fa-fw"></i>
				Revistas
			</a>
		</li>
		
		<li>
			<a href="#">
				<i class="fa fa-bar-chart-o fa-fw"></i>
				BLABLA
				<span class="fa arrow"></span>
			</a>
			<ul class="nav nav-second-level collapse">
				<li><a href="#">Pendentes</a></li>
				<li><a href="#">Em Avaliação</a></li>
			</ul> <!-- /.nav-second-level -->
		</li>
		
		<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
				Tables</a></li>
		<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>
				Forms</a></li>
		<li><a href="#"><i class="fa fa-wrench fa-fw"></i> UI
				Elements<span class="fa arrow"></span></a>
			<ul class="nav nav-second-level collapse">
				<li><a href="panels-wells.html">Panels and Wells</a></li>
				<li><a href="buttons.html">Buttons</a></li>
				<li><a href="notifications.html">Notifications</a></li>
				<li><a href="typography.html">Typography</a></li>
				<li><a href="grid.html">Grid</a></li>
			</ul> <!-- /.nav-second-level --></li>
		<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
				Multi-Level Dropdown<span class="fa arrow"></span></a>
			<ul class="nav nav-second-level collapse">
				<li><a href="#">Second Level Item</a></li>
				<li><a href="#">Second Level Item</a></li>
				<li><a href="#">Third Level <span class="fa arrow"></span></a>
					<ul class="nav nav-third-level collapse">
						<li><a href="#">Third Level Item</a></li>
						<li><a href="#">Third Level Item</a></li>
						<li><a href="#">Third Level Item</a></li>
						<li><a href="#">Third Level Item</a></li>
					</ul> <!-- /.nav-third-level --></li>
			</ul> <!-- /.nav-second-level --></li>
		<li class="active"><a href="#"><i class="fa fa-files-o fa-fw"></i>
				Sample Pages<span class="fa arrow"></span></a>
			<ul class="nav nav-second-level collapse in">
				<li><a href="blank.html">Blank Page</a></li>
				<li><a href="login.html">Login Page</a></li>
			</ul> <!-- /.nav-second-level --></li>
	</ul>
	<!-- /#side-menu -->
</div>