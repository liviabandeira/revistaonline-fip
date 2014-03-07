package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="autor")
public class Autor extends TipoPesquisador {

	@NotNull
	private String lattes;

	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}
	
}
