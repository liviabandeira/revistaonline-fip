package br.com.fip.gati.revistaonline.domain.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class FileUtil {
	
	Properties prop = new Properties();
	private Localization localization;
	private ServletContext context;
	private final static String NAME_OF_PROPERTIES = "fileupload";
	
	public void salva(UploadedFile arq, ServletContext context) {
		ResourceBundle build = ResourceBundle.getBundle(NAME_OF_PROPERTIES);
		String path = context.getRealPath(String.valueOf(build.getObject("upload.target.dir")));
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
