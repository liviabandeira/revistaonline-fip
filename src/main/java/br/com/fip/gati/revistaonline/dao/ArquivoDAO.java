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
	
	private File pastaArquivo;
	static int nome = 0;
	
	public ArquivoDAO (ServletContext context){
		
		String caminhoArquivo = context.getRealPath("WEB-INF/artigo");
		pastaArquivo = new File(caminhoArquivo);
		pastaArquivo.mkdir();
	}
	
	public void salva(UploadedFile arquivo){
		
		File destino = new File(pastaArquivo, String.valueOf(nome) + ".txt");
		nome ++;
		try {
			IOUtils.copy(arquivo.getFile(), new FileOutputStream(destino));
		} catch (IOException e ) {
			throw new RuntimeException("Erro ao copiar arquivo", e);
		}
		
	}

}

