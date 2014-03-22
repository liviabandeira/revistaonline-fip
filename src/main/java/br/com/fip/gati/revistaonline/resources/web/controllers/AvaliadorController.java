package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.Arrays;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;

@Resource
public class AvaliadorController {
	private AvaliadorRepositorio repositorio;
	private Result result;
	
	public AvaliadorController(AvaliadorRepositorio repositorio, Result result) {
		this.repositorio = repositorio;
		this.result = result;
	}
	
	@Get("/avaliadores/{id:[0-9]}")
	public void buscar(Long id) {
		Avaliador avaliador = repositorio.load(id);
		result.include("avaliadorList", Arrays.asList(avaliador));
	}
	
}
