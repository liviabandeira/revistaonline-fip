package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="editor")
public class Editor extends Entity {

	@OneToOne(fetch=FetchType.LAZY)
	private Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}