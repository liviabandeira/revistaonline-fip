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
	private Integer volume;
	
	@NotNull
	@Min(value=1)
	private Integer numero;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="revista_id", nullable=false)
	private Revista revista;
	
	//private List<Artigo> artigos = null;
	
	public Edicao() {	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	
}
