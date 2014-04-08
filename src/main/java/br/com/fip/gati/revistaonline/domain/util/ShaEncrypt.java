package br.com.fip.gati.revistaonline.domain.util;

import java.security.MessageDigest;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.environment.Environment;

public class ShaEncrypt {


	public static String hash(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			generatedPassword = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return generatedPassword;
	}
}
