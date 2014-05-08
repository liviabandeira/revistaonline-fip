package br.com.fip.gati.revistaonline.infraestructure.mail;

import org.apache.commons.mail.Email;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.simplemail.AsyncMailer;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.simplemail.aws.MockMailer;
import br.com.fip.gati.revistaonline.infrastructure.mail.EmailException;
import br.com.fip.gati.revistaonline.infrastructure.mail.RevistaMailer;
import static org.mockito.Mockito.*;

public class MailTest {
	private Environment env;
	private Mailer vraptorMailer;
	private AsyncMailer aMailer;
	private RevistaMailer mailer;
	
	@Before
	public void setup() {
		env = mock(Environment.class);
		vraptorMailer = mock(MockMailer.class);
		aMailer = mock(AsyncMailer.class);
		mailer = new RevistaMailer(env, vraptorMailer, aMailer);
	}
	
	@Test
	public void deveEnviarEmailComTodosAsPropriedades() throws EmailException, org.apache.commons.mail.EmailException {
		when(env.get("vraptor.simplemail.main.from")).thenReturn("no-reply@myapp.com");

		mailer.send("Assunto Teste", "Olá, Mundo", "test@teste.com.br");
		verify(vraptorMailer).send(any(Email.class));
	}
	
}
