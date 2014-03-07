package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="avaliador")
public class Avaliador extends TipoUsuario {

	@Override
	public boolean hasTipo(Class<? extends TipoUsuario> tipo) {
		return tipo.equals(Avaliador.class);
	}

}
