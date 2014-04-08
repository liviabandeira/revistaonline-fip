package br.com.fip.gati.revistaonline.domain.repositorio;

import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;

public interface AvaliadorRepositorio extends Repositorio<Avaliador> {

	public Avaliador getAvaliador(Autor autor);
	
}
