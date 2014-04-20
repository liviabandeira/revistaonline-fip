package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name="edicao")
public class Edicao extends Entity {

	@NotNull
	@Min(value=1)
	private String volume;
	
	@NotNull
	@Min(value=1)
	private String numero;
	
	@NotNull
	private Integer ano;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="revista_id", nullable=false)
	private Revista revista;
	
	//private List<Artigo> artigos = null;
	
	public Edicao() {}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
