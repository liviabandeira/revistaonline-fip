package br.com.fip.gati.revistaonline.domain.repositorio;


import java.util.List;

import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.Revista;


public interface ArtigoRepositorio extends Repositorio<Artigo> {

	public List<Artigo> getArtigosPendentesParaAvaliacao(Revista revista);
}

