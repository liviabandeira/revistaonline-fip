package br.com.fip.gati.revistaonline.domain.util;

import java.security.MessageDigest;
import java.util.ResourceBundle;

public class ShaEncrypt {
	private final static String NAME_OF_PROPERTIES = "hash";


	public static String hash(String passwordToHash) {
		String generatedPassword = null;
		ResourceBundle build = ResourceBundle.getBundle(NAME_OF_PROPERTIES);
		try {
			MessageDigest md = MessageDigest.getInstance(String.valueOf(build.getObject("encryption.type")));
			md.update(String.valueOf(build.getObject("encryption.salt")).getBytes());
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
