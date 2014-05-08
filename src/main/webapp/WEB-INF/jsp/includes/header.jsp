<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
                <a class="navbar-brand" href="${linkTo[IndexController].index}">Revista Online FIP</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">	
            
                <ul class="nav navbar-nav">
                
                    <li><a href="${pageContext.request.contextPath}/revistas">Revistas</a></li>
<!--                <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">1 Column Portfolio</a>
                            </li>
                            <li><a href="#">2 Column Portfolio</a>
                            </li>
                            <li><a href="#">3 Column Portfolio</a>
                            </li>
                            <li><a href="#">4 Column Portfolio</a>
                            </li>
                            <li><a href="#">Single Portfolio Item</a>
                            </li>
                        </ul>
                    </li>
-->
				</ul>
				<ul class="nav navbar-nav pull-right">
                    <c:if test="${!usuarioLogado.logado}">
			          	<li class="dropdown">
			            <a class="dropdown-toggle" href="#" data-toggle="dropdown">Entrar <strong class="caret"></strong></a>
			            <div class="dropdown-menu" style="padding: 15px; width: 200px; padding-bottom: 0px;">
			            	<form action="${linkTo[LoginController].auth}" method="post">
			            		<div class="form-group">
								  	<input id="user_username" class="form-control" 
								  	type="text" placeholder="<fmt:message key="app.login" />" name="usuario.login" />
			            		</div>
			            		
			            		<div class="form-group">
								  	<input id="user_password" class="form-control" 
								  	type="password" placeholder="<fmt:message key="app.senha"/>" name="usuario.senha"/>
			            		</div>
			            		
							 	<div class="form-group">
									<input class="btn btn-primary" style="width: 100%;" type="submit" name="commit" value="Entrar" />
							 	</div>
							</form> 
			            </div>
			          </li>
			          <li><a href="${linkTo[UsuarioController].formulario}">Crie sua conta!</a></li>
		          </c:if>
                </ul>
                
                <c:if test="${usuarioLogado.logado}">
	                <ul class="nav navbar-nav pull-right">
	                	<li class="dropdown">
					    	<a class="active" role="button" data-toggle="dropdown" href="#" style="color: #243EAA;">
						    	<span class="glyphicon glyphicon-user"></span>
						    	${usuarioLogado.usuarioInfo.login}
						    	<b class="caret"></b>
					    	</a>
					        <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
<!-- 					          <li role="presentation"><a role="menuitem" tabindex="-1" href="http://twitter.com/fat">Action</a></li> -->
<!-- 					          <li role="presentation"><a role="menuitem" tabindex="-1" href="http://twitter.com/fat">Another action</a></li> -->
					          <li role="presentation"><a role="menuitem" tabindex="-1" href="${linkTo[UsuarioController].perfil[usuarioLogado.ID]}">Meu Perfil</a></li>
					          <li role="presentation"><a role="menuitem" tabindex="-1" href="${linkTo[OfficeController].index}">Alterar Senha</a></li>
					          <li role="presentation" class="divider"></li>
					          <li role="presentation"><a role="menuitem" tabindex="-1" href="${linkTo[OfficeController].index}">Office</a></li>
					          <li role="presentation" class="divider"></li>
					          <li role="presentation"><a role="menuitem" tabindex="-1" href="${linkTo[LoginController].logout}">Sair</a></li>
					        </ul>
						</li>	
	                </ul>
                </c:if>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
