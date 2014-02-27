package br.com.fip.gati.revistaonline.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ArquivoDAO {

	static int nome = 0;

	public void salva(UploadedFile arq) {
		nome++;
		File destino = new File(nome + ".txt");
		try {
			IOUtils.copyLarge(arq.getFile(), new FileOutputStream(destino));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar arquivo", e);
		}

	}

}