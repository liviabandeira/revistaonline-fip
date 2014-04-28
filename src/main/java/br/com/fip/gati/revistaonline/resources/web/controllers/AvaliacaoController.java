package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Revista;
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
	
	@Get("/avaliacao")
	public void avaliacao() {
	}
	
	@Get("/avaliacoes/new")
	public void link(){
		
	}
	
	@Get("/avaliacao/new")
	public AvaliacaoArtigo newAvalicao() {
		result.include("action", "new");
		return new AvaliacaoArtigo();
	}

	@Post("/criaravaliacao")
	public void salvar (AvaliacaoArtigo avaliacaoArtigo, Artigo artigo, String radio1, String radio2, String radio3, String radio4, String radio5 ) {
		result.include("action", "new");
		avaliacaoRepositorio.save(avaliacaoArtigo);
		/*avaliacaoArtigo.setCriterio1(radio1);
		avaliacaoArtigo.setCriterio2(radio2);
		avaliacaoArtigo.setCriterio3(radio3);
		avaliacaoArtigo.setCriterio4(radio4);
		avaliacaoArtigo.setCriterio5(radio5);
		*/
		result.redirectTo(this).avaliacao();
	}
}
