package br.com.fip.gati.revistaonline.infrastructure.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.simplemail.Mailer;


@Component
public class RevistaMailer {
	private Environment env;
	private Mailer mailer;
	
	public RevistaMailer(Environment env, Mailer mail) {
		this.env = env;
		this.mailer = mail;
	}

	public void send(String assunto, String corpo, String... para) throws EmailException {
		try {
			Email email = new SimpleEmail();
			email.setFrom(this.env.get("vraptor.simplemail.main.from"));
			email.setSubject(assunto);
			email.setMsg(corpo);
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
