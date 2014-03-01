package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.fip.gati.revistaonline.dao.ArquivoDAO;

@Resource
public class ArquivoController {


	private ArquivoDAO arquivoDAO;
	private final Result result;

	public ArquivoController(Result result, ArquivoDAO arq) {
		this.result = result;
		this.arquivoDAO = arq;
	}

	@Get("/upload")
	public void formulario() {
	}

	@Post("/upload/file")
	public void upload(UploadedFile file) {
		this.arquivoDAO.salva(file);
        result.redirectTo(IndexController.class).index();

	}

}
