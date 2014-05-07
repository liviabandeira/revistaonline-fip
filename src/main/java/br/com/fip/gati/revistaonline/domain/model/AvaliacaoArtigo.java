package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import br.com.fip.gati.revistaonline.domain.model.enums.AvaliacaoStatusEnum;

@javax.persistence.Entity
@Table(name="avaliacao")
public class AvaliacaoArtigo extends Entity {

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Artigo artigo;
	
	@NotNull
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="avaliador_id", nullable=false)
	private Avaliador avaliador;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AvaliacaoStatusEnum status;
	
	
	private String criterio1;
	
	
	private String criterio2;
	
	
	private String criterio3;
	
	
	private String criterio4;
	
	
	private String criterio5;
	
	
	@Size(max=255)
	private String comentario;

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public String getCriterio1() {
		return criterio1;
	}

	public void setCriterio1(String criterio1) {
		this.criterio1 = criterio1;
	}

	public String getCriterio2() {
		return criterio2;
	}

	public void setCriterio2(String criterio2) {
		this.criterio2 = criterio2;
	}

	public String getCriterio3() {
		return criterio3;
	}

	public void setCriterio3(String criterio3) {
		this.criterio3 = criterio3;
	}

	public String getCriterio4() {
		return criterio4;
	}

	public void setCriterio4(String criterio4) {
		this.criterio4 = criterio4;
	}

	public String getCriterio5() {
		return criterio5;
	}

	public void setCriterio5(String criterio5) {
		this.criterio5 = criterio5;
	}

	public AvaliacaoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AvaliacaoStatusEnum status) {
		this.status = status;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public boolean isPendente() {
		return status == AvaliacaoStatusEnum.P;
	}
	
}
