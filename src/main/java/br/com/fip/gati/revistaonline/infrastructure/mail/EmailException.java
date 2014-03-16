package br.com.fip.gati.revistaonline.infrastructure.mail;


public class EmailException extends Exception {

	public EmailException(String msg) {
		super(msg);
	}
	
	public EmailException(Throwable t) {
		super(t);
	}
	
}
