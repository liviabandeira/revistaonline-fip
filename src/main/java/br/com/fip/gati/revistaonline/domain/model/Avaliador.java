package br.com.fip.gati.revistaonline.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="avaliador")
public class Avaliador extends TipoUsuario {
	
	@ManyToMany(mappedBy="avaliadores")
	private List<Revista> revista;

	@Override
	public boolean hasTipo(Class<? extends TipoUsuario> tipo) {
		return tipo.equals(Avaliador.class);
	}

	public List<Revista> getRevista() {
		return revista;
	}

	public void setRevista(List<Revista> revista) {
		this.revista = revista;
	}
	
	

}
