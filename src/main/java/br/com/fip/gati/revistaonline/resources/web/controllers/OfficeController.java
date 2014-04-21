package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;

@Resource
public class OfficeController {
	private Result result;
	private RevistaRepositorio revistas;
	
	public OfficeController(Result result, RevistaRepositorio revistas) {
		this.result = result;
		this.revistas = revistas;
	}
	
	public void index() {
		
	}
	
	public void submissoes() {
		
	}
	
	public void revistas() {
		result.include("revistaList", revistas.listAll());
	}
	
	public void revisoesPendentes() {
		
	}
	
	public void revisoesConcluidas() {
		
	}
}
