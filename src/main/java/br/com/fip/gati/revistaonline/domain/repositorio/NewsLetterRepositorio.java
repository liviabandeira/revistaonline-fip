package br.com.fip.gati.revistaonline.domain.repositorio;

import br.com.fip.gati.revistaonline.domain.model.Newsletter;
import br.com.fip.gati.revistaonline.domain.model.Revista;

public interface NewsLetterRepositorio extends Repositorio<Newsletter> {
	
	public boolean verificaNewsletterExistente(Revista revista, String email);
	public Newsletter getNewsletter(String email);
}
