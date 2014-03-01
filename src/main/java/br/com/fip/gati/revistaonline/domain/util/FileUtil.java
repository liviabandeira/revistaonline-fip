package br.com.fip.gati.revistaonline.domain.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Component
public class FileUtil {
	
	Properties prop = new Properties();
	private Localization localization;
	
	public void salva(UploadedFile arq, String path) {
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
