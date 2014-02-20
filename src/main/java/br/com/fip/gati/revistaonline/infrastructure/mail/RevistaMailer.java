package br.com.fip.gati.revistaonline.infrastructure.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.simplemail.Mailer;


@Component
public class RevistaMailer {
	private Mailer mailer;
	
	public RevistaMailer(Mailer mail) {
		this.mailer = mail;
	}

	public void send(String assunto, String msg, String... para) throws EmailException {
		try {
			Email email = new SimpleEmail();
			email.setSubject(assunto);
			email.setMsg(msg);
			for(String dest : para) {
				email.addTo(dest);
			}
			send(email);
		} catch (org.apache.commons.mail.EmailException ex) {
			throw new EmailException(ex);
		}
	}

	private void send(Email email) throws EmailException {
		try {
			mailer.send(email);
		} catch (org.apache.commons.mail.EmailException e) {
			throw new EmailException(e);
		}
	}
}
