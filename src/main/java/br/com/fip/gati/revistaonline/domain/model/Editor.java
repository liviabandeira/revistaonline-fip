package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="editor")
public class Editor extends TipoUsuario {

	@Override
	public boolean hasTipo(Class<? extends TipoUsuario> tipo) {
		return tipo.equals(Editor.class);
	}

}