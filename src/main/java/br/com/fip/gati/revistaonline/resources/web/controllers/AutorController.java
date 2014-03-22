package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.domain.repositorio.AutorRepositorio;

@Resource
public class AutorController {
	private AutorRepositorio repositorio;
	private Result result;
	
	public AutorController(AutorRepositorio repositorio, Result result) {
		this.repositorio = repositorio;
		this.result = result;
	}
	
}
