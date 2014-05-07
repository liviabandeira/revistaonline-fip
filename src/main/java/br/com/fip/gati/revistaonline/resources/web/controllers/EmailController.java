package br.com.fip.gati.revistaonline.resources.web.controllers;

import org.apache.commons.mail.EmailException;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.fip.gati.revistaonline.infrastructure.mail.RevistaMailer;

@Resource
public class EmailController {
	private final RevistaMailer revistaMailer;

	//Pra essa bomba funcionar tem que ir la no web.xml e alterar o context-param de development pra production
	// e setar o enviroment.controller para true;
	
	public EmailController(RevistaMailer revistaMailer) {
		this.revistaMailer = revistaMailer;
	}

	@Path("/password/send")
	public void sendMail() throws EmailException, br.com.fip.gati.revistaonline.infrastructure.mail.EmailException {
		revistaMailer.send("Teste", "Teste", "destinatario@flango.com");
		
	}

}
