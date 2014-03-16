package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name="artigo")
public class Artigo extends Entity {

	@NotNull
	private String filepath;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}
