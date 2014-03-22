package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="autor")
public class Autor extends Entity {

	private String nome;
	private String instituicao;
	private String lattes;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	@OneToOne(mappedBy="autor")
	private Avaliador avaliador;
	
	@OneToOne(mappedBy="autor")
	private Editor editor;
	
	
	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	
	public boolean isAvaliador() {
		return avaliador != null;
	}
	
	public boolean isEditor() {
		return editor != null;
	}
	
}
