package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.fip.gati.revistaonline.domain.model.Arquivo;

@Resource
public class ArquivoController {
	
	private final Arquivo arquivo;
	private final Result result;
	
	public ArquivoController (Result result, Arquivo arquivo ){
		this.arquivo = arquivo;
		this.result = result;
	}
	
	@Get("/upload") 
	public void formulario(){
	}
	
	@Post("/upload")
	public void upload (final UploadedFile arquivo){
		
		this.arquivo.salva(arquivo);
		result.redirectTo(LoginController.class).login();
	}

}