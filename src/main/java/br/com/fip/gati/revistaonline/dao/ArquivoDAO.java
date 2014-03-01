package br.com.fip.gati.revistaonline.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ArquivoDAO {
	
	private ServletContext cont;
	
	public ArquivoDAO(ServletContext context){
		super();
		this.cont = context;
	}
	
	public void salva(UploadedFile arq) {
		String path = cont.getRealPath("/WEB-INF/arquivos");
		File folder = new File(path);
		folder.mkdir(); 
		File destino = new File(path, arq.getFileName());
		try {
			IOUtils.copyLarge(arq.getFile(), new FileOutputStream(destino));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar arquivo", e);
		}

	}

}
