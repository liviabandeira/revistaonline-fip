package br.com.fip.gati.revistaonline.domain.repositorio;

import java.util.List;

import br.com.fip.gati.revistaonline.domain.model.Edicao;
import br.com.fip.gati.revistaonline.domain.model.Revista;

public interface EdicaoRepositorio extends Repositorio<Edicao> {

	public List<Edicao> listByRevista(Revista revista);
	
}
