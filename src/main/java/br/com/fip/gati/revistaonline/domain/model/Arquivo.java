package br.com.fip.gati.revistaonline.domain.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;


@Component
public class Arquivo {
	
	private File pastaArquivo;
	static int nome = 0;
	
	public Arquivo (ServletContext context){
		
		pastaArquivo = new File("/WEB-INF/jsp/nigga");
		System.out.println("XEGOAQUI");
		pastaArquivo.mkdir();
		System.out.println("TRETA!");
	}
	
	public void salva(UploadedFile arquivo){
		System.out.println("YOYO1");
		File destino = new File(pastaArquivo, String.valueOf(nome) + ".txt");
		System.out.println("YOYO!");
		nome ++;
		try {
			IOUtils.copyLarge(arquivo.getFile(), new FileOutputStream(destino));
		} catch (IOException e ) {
			throw new RuntimeException("Erro ao copiar arquivo", e);
		}
		
	}

}
