package br.com.fip.gati.revistaonline.domain.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class FileUtil {
	
	Properties prop = new Properties();
	
	public void salva(UploadedFile arq, String path) {
		File folder = new File(path);
		folder.mkdirs();
		File destino = new File(path, arq.getFileName());
		try {
			IOUtils.copyLarge(arq.getFile(), new FileOutputStream(destino));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar arquivo", e);
		}

	}
	//Redinmensionar imagem de capa
//	
//	private File resizer(int width, int height, File file) throws IOException{
//		BufferedImage image = ImageIO.read(file);
//		BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, width, height , Scalr.OP_ANTIALIAS);
//		ImageIO.write(thumbnail, "jpg", file);
//		return file;
//	}


}
