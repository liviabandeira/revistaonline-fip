package br.com.fip.gati.revistaonline.domain.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name="avaliador")
public class Avaliador extends Entity {
	
	@OneToOne(fetch=FetchType.LAZY)
	private Autor autor;
	
	@ManyToMany(mappedBy="avaliadores")
	private List<Revista> revista;
	
	public Avaliador() {
	}
	
	public Avaliador(Autor autor) {
		this.autor = autor;
	}

	public List<Revista> getRevista() {
		return revista;
	}

	public void setRevista(List<Revista> revista) {
		this.revista = revista;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String getNome() {
		return autor.getPrenome() + " " + autor.getNome() + " " + autor.getSobrenome();
	}
	

}
