package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;

@Resource
public class AvaliacaoController {
	private Result result;
	private ArtigoRepositorio artigos;
	
	public AvaliacaoController(Result result, ArtigoRepositorio artigos) {
		this.result = result;
		this.artigos = artigos;
	}
	
}
