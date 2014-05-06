package br.com.fip.gati.revistaonline.domain.util;

import java.util.UUID;

public class GeraToken {
		
	public static String gerarToken() {
		
		String token = UUID.randomUUID().toString();
		return token;
	}
}
