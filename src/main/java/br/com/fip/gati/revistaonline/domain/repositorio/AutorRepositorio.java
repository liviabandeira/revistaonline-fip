package br.com.fip.gati.revistaonline.domain.repositorio;

import java.util.List;

import br.com.fip.gati.revistaonline.domain.model.Autor;

public interface AutorRepositorio extends Repositorio<Autor> {

	public List<Autor> getPorPreNome(String nome);
	
}
