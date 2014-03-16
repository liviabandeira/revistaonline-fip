package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="autor")
public class Autor extends TipoUsuario {

	@NotNull
	private String lattes;

	@Override
	public boolean hasTipo(Class<? extends TipoUsuario> tipo) {
		return tipo.equals(Autor.class);
	}

	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	
}
