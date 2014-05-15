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
	
	
	private Integer criterio1;
	
	
	private Integer criterio2;
	
	
	private Integer criterio3;
	
	
	private Integer criterio4;
	
	
	private Integer criterio5;
	
	
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

	public Integer getCriterio1() {
		return criterio1;
	}

	public void setCriterio1(Integer criterio1) {
		this.criterio1 = criterio1;
	}

	public Integer getCriterio2() {
		return criterio2;
	}

	public void setCriterio2(Integer criterio2) {
		this.criterio2 = criterio2;
	}

	public Integer getCriterio3() {
		return criterio3;
	}

	public void setCriterio3(Integer criterio3) {
		this.criterio3 = criterio3;
	}

	public Integer getCriterio4() {
		return criterio4;
	}

	public void setCriterio4(Integer criterio4) {
		this.criterio4 = criterio4;
	}

	public Integer getCriterio5() {
		return criterio5;
	}

	public void setCriterio5(Integer criterio5) {
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
