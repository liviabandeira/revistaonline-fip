package br.com.fip.gati.revistaonline.domain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class ShaEncrypt {
	private static String salt = "Y0b1tchm4k3m34s4ndw1ch!@#$%^&*()";

	public static String HashinPass(String passwordToHash) {
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
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
	public static void main(String[] args) {
		System.out.println(HashinPass("diego"));
		System.out.println(HashinPass("diego").length());
		String teste = Hashing.sha256().hashString("diego", Charsets.UTF_8).toString();
		System.out.println(teste);
	}
}
