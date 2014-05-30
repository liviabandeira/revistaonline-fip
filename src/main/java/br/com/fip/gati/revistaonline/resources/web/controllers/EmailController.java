package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.io.IOException;

import org.apache.commons.mail.EmailException;

import freemarker.template.TemplateException;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.freemarker.Freemarker;
import br.com.fip.gati.revistaonline.infrastructure.mail.RevistaMailer;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;

@Resource
public class EmailController {
	private final RevistaMailer revistaMailer;
	private final Freemarker freemarker;

	// Pra essa bomba funcionar tem que ir la no web.xml e alterar o
	// context-param de development pra production
	// e setar o enviroment.controller para true;

	public EmailController(RevistaMailer revistaMailer, Freemarker freemarker) {
		this.revistaMailer = revistaMailer;
		this.freemarker = freemarker;
	}

	@Path("/form")
	public void form() {

	}

	@Path("/password/send")
	public void sendMail() throws EmailException, br.com.fip.gati.revistaonline.infrastructure.mail.EmailException, IOException,
			TemplateException {
		String link = "http://aquivaiolink.com";
		String body = freemarker.use("send_mail").with("link", link).getContent();
		revistaMailer.send("Alguem solicitou uma nova senha para sua conta do Revista Online", body, "email@dodestinatario.com");

	}
}
