package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.enums.AvaliacaoStatusEnum;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliacaoRepositorio;

@Resource
public class AvaliacaoController {
	private Result result;
	private ArtigoRepositorio artigos;
	private AvaliacaoRepositorio avaliacaoRepositorio;
	
	public AvaliacaoController(Result result, ArtigoRepositorio artigos, AvaliacaoRepositorio avaliacao) {
		this.result = result;
		this.artigos = artigos;
		this.avaliacaoRepositorio = avaliacao;
	}
	
	@Get("/avaliacao/{avaliacao.id}")
	public void formAvaliacao(AvaliacaoArtigo avaliacao){
		result.include("avaliacao",this.avaliacaoRepositorio.load(avaliacao.getId()));
	}
		
	@Post("/avaliacao/{avaliacao.id}/criaravaliacao")
	public void salvar (AvaliacaoArtigo avaliacao, String criterio1, String criterio2, String criterio3, String criterio4, String criterio5, String comentarios) {
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
