package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@javax.persistence.Entity
@Table(name="pesquisador")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class TipoUsuario extends Entity {

	private String instituicao;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Transient
	public abstract boolean hasTipo(Class<? extends TipoUsuario> tipo);
	
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
