package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.fip.gati.revistaonline.domain.util.FileUtil;

@Resource
public class ArquivoController {

	private FileUtil fileUtil;
	private final Result result;
	private ServletContext context;
	private final static String NAME_OF_PROPERTIES = "development";

	public ArquivoController(Result result, FileUtil arq, ServletContext context) {
		this.result = result;
		this.fileUtil = arq;
		this.context = context;
	}

	@Get("/upload")
	public void formulario() {
	}

	@Post("/upload/file")
	public void upload(UploadedFile file) {
		ResourceBundle build = ResourceBundle.getBundle(NAME_OF_PROPERTIES);
		this.fileUtil.salva(file,context.getRealPath(String.valueOf(build.getObject("upload.target.dir"))));
        result.redirectTo(IndexController.class).index();

	}

}
