package br.com.fip.gati.revistaonline.resources.web.controllers;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.application.AvaliacaoArtigoService;
import br.com.fip.gati.revistaonline.domain.exception.RevistaException;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;
import br.com.fip.gati.revistaonline.resources.web.Controllers;

@Resource
public class OfficeController {
	private Result result;
	private RevistaRepositorio revistas;
	private ArtigoRepositorio artigos;

	private AvaliadorRepositorio avaliadores;

	private AvaliacaoArtigoService avaliacaoService;
	
	public OfficeController(Result result, RevistaRepositorio revistas, ArtigoRepositorio artigos, AvaliadorRepositorio avaliadores, AvaliacaoArtigoService avaliacaoService) {
		this.result = result;
		this.revistas = revistas;
		this.artigos = artigos;
		this.avaliacaoService = avaliacaoService;
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
	
	@Get("/office/revista/{revista.id}/artigos/pendentes")
	public void artigosDisponiveisParaAvaliacao(Revista revista) {
		Revista revistadb = revistas.load(revista.getId());
		result.include("revista", revistadb);
		result.include("avaliadores", revistadb.getAvaliadores());
		result.include("artigosList", artigos.getArtigosPendentesParaAvaliacao(revista));
	}
	
	@Post("/office/artigo/avaliadores")

	public void associarAvaliadores(Revista revista, Artigo artigo, String tituloSelecionado, List<Avaliador> avaliadores) {
		result.include("tituloSelecionado", tituloSelecionado);
		result.include("artigo", artigo);
		result.include("avaliadores", avaliadores);

		if(!isAssociacaoAvaliadoresValido(revista, artigo, avaliadores)) {
			result.redirectTo(this).artigosDisponiveisParaAvaliacao(revista);
			return;
		}
		
		try {
			avaliacaoService.associarAvaliadores(artigo, avaliadores);
			
			Controllers.includeSucess(result, "Operação realizada com sucesso!");
			result.redirectTo(this).artigosDisponiveisParaAvaliacao(revista);
		} catch(RevistaException ex) {
			ex.printStackTrace();

			Controllers.includeParameterError(result, "modalError", ex.getMessage());
			result.redirectTo(this).artigosDisponiveisParaAvaliacao(revista);
		} catch (Exception e) {
			e.printStackTrace();
			
			Controllers.includeError(result, "Erro: Operação não realizada.");
			result.redirectTo(this).artigosDisponiveisParaAvaliacao(revista);
		}
	}
	
	private boolean isAssociacaoAvaliadoresValido(Revista revista, Artigo artigo, List<Avaliador> avaliadores) {
		final int DEFAULT_AVALIADOR = -1;
		boolean valido = true;
		
		if(avaliadores == null || avaliadores.size() != 2) {
			Controllers.includeParameterError(result, "modalError", "Você deve selecionar 02 (dois) avaliadores");
			return false;
		}
		
		for(Avaliador av : avaliadores) {
			if(av.getId().intValue() == DEFAULT_AVALIADOR) {
				Controllers.includeParameterError(result, "modalError", "Você deve selecionar 02 (dois) avaliadores");
				return false;
			}
		}
		
		Set<Avaliador> avs = new HashSet<Avaliador>();
		for(Avaliador av : avaliadores) {
			if(avs.contains(av)) {
				Controllers.includeParameterError(result, "modalError", "Os avaliadores não podem ser iguais");
				return false;
			}
			avs.add(av);
		}
		
		return valido;
	}
}
