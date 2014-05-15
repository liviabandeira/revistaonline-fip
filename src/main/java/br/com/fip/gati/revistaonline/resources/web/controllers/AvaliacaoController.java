package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.enums.AvaliacaoStatusEnum;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliacaoRepositorio;
import br.com.fip.gati.revistaonline.resources.web.Controllers;

@Resource
public class AvaliacaoController {
	private Result result;
	private ArtigoRepositorio artigos;
	private AvaliacaoRepositorio avaliacaoRepositorio;
	private final Validator validator;
	
	public AvaliacaoController(Result result, ArtigoRepositorio artigos, AvaliacaoRepositorio avaliacao,Validator validator) {
		this.result = result;
		this.artigos = artigos;
		this.avaliacaoRepositorio = avaliacao;
		this.validator = validator;
	}
	
	@Get("/avaliacao/{avaliacao.id}")
	public void formAvaliacao(AvaliacaoArtigo avaliacao){
		result.include("avaliacao",this.avaliacaoRepositorio.load(avaliacao.getId()));
	}
		
	@Post("/avaliacao/{avaliacao.id}/criaravaliacao")
	public void salvar (AvaliacaoArtigo avaliacao, Integer criterio1, Integer criterio2, Integer criterio3, Integer criterio4, Integer criterio5, String comentarios) {
		if(criterio1 == null || criterio2 == null || criterio3 == null || criterio4 == null || criterio5 == null){
			Controllers.includeError(result, "Todos os campos devem ser preenchidos!"); 
			result.redirectTo(this).formAvaliacao(avaliacao);
		}else {
			AvaliacaoArtigo avalia = this.avaliacaoRepositorio.load(avaliacao.getId());
			avalia.setCriterio1(criterio1);
			avalia.setCriterio2(criterio2);
			avalia.setCriterio3(criterio3);
			avalia.setCriterio4(criterio4);
			avalia.setCriterio5(criterio5);
			avalia.setComentario(comentarios); 
			avalia.setStatus(AvaliacaoStatusEnum.A); 
			avaliacaoRepositorio.update(avalia);
			result.redirectTo(OfficeController.class).revisoesConcluidas(); 
		}	
		
	}
}
