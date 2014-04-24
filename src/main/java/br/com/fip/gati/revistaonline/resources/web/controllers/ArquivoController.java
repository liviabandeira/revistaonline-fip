package br.com.fip.gati.revistaonline.resources.web.controllers;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.fip.gati.revistaonline.domain.util.FileUtil;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;

@Resource
public class ArquivoController {

	private FileUtil fileUtil;
	private final Result result;
	private ServletContext context;
	private Environment environment;
	private UsuarioLogado usuarioLogado;

	public ArquivoController(Result result, FileUtil arq, ServletContext context, Environment environment, UsuarioLogado usuarioLogado) {
		this.result = result;
		this.fileUtil = arq;
		this.context = context;
		this.environment = environment;
		this.usuarioLogado = usuarioLogado;
	}

	@Get("/upload")
	public void formulario() {
	}

	@Post("/upload/file")
	public void upload(UploadedFile file) {
	StringBuilder sb = new StringBuilder();
	sb.append(context.getRealPath(this.environment.get("upload.target.dir"))).append("/").append(usuarioLogado.getUsuarioInfo().getID());
	this.fileUtil.salva(file,sb.toString());
    result.redirectTo(IndexController.class).index();
	}


}
