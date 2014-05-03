package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fip.gati.revistaonline.application.AvaliacaoArtigoService;
import br.com.fip.gati.revistaonline.domain.exception.RevistaException;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliacaoRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;

@Resource
public class OfficeController {
	private Result result;
	private RevistaRepositorio revistas;
	private ArtigoRepositorio artigos;
	private AvaliadorRepositorio avaliadores;
	private AvaliacaoArtigoService avaliacaoService;
	private AvaliacaoRepositorio avaliacoes; 
	private UsuarioLogado usuarioLogado;
	private UsuarioRepositorio usuario; 
	
	public OfficeController(Result result, RevistaRepositorio revistas, ArtigoRepositorio artigos, AvaliadorRepositorio avaliadores, AvaliacaoArtigoService avaliacaoService, UsuarioLogado usuarioLogado, AvaliacaoRepositorio avaliacoes, UsuarioRepositorio usuario) {
		this.result = result;
		this.revistas = revistas;
		this.artigos = artigos;
		this.avaliacaoService = avaliacaoService;
		this.usuarioLogado = usuarioLogado;
		this.avaliacoes = avaliacoes; 
		this.usuario = usuario;
		this.avaliadores = avaliadores;
	}
	
	public void index() {
		
	}
	
	public void submissoes() {
		
	}
	
	public void revistas() {
		result.include("revistaList", revistas.listAll());
	}
	
	public void revisoesPendentes() {
		Long idLogado = usuarioLogado.getUsuarioInfo().getID();
		Usuario usu = usuario.getUsuario(idLogado);
		Autor autor = usu.getAutor();
		Avaliador avaliadorbd = avaliadores.getAvaliador(autor);
		List<Artigo> artigos = avaliacoes.getArtigosDeAvaliacoesPendente(avaliadorbd);
		result.include("artigoList", artigos);
	}
	
	public void revisoesConcluidas() {
		Long idLogado = usuarioLogado.getUsuarioInfo().getID();
		Usuario usu = usuario.getUsuario(idLogado);
		Autor autor = usu.getAutor();
		Avaliador avaliadorbd = avaliadores.getAvaliador(autor);
		List<Artigo> artigos = avaliacoes.getArtigosDeAvaliacoesConcluidas(avaliadorbd);
		result.include("artigoList", artigos);
	}
	
	@Get("/office/revista/{revista.id}/artigos/pendentes")
	public void artigosDisponiveisParaAvaliacao(Revista revista) {
		Revista revistadb = revistas.load(revista.getId());
		result.include("revista", revistadb);
		result.include("avaliadores", revistadb.getAvaliadores());
		result.include("artigosList", artigos.getArtigosPendentesParaAvaliacao(revista));
	}
	
	@Post("/office/artigo/avaliadores")
	public void associarAvaliadores(Revista revista, Artigo artigo, List<Avaliador> avaliadores) throws RevistaException {
		//TODO validacoes
		avaliacaoService.associarAvaliadores(artigo, avaliadores);
		result.redirectTo(this).artigosDisponiveisParaAvaliacao(revista);
	}
}
