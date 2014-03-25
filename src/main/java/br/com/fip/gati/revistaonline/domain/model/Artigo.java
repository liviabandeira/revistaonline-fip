package br.com.fip.gati.revistaonline.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name="artigo")
public class Artigo extends Entity {
	
	
	
	@NotNull
	private String titulo;
	
	@NotNull
	private String resumo;
	@NotNull
	private String keyWord;
	@NotNull
//	private List<Autor> autores;
	//notNull
	private String secao;
	@NotNull
	private String idioma;
	@NotNull
	private String areaSubAreaDoConhecimento;
	@NotNull
	private String geoEspacial;
	@NotNull
	private String cronologicaOuHistorica;
	@NotNull
	private String caracteristicasDaAmostragemDaPesquisa;
	
	@NotNull
	private String condicoesParaSubmissao;
	@NotNull
	private String agencias;
	public String getAreaSubAreaDoConhecimento() {
		return areaSubAreaDoConhecimento;
	}
	public void setAreaSubAreaDoConhecimento(String areaSubAreaDoConhecimento) {
		this.areaSubAreaDoConhecimento = areaSubAreaDoConhecimento;
	}
	public String getGeoEspacial() {
		return geoEspacial;
	}
	public void setGeoEspacial(String geoEspacial) {
		this.geoEspacial = geoEspacial;
	}
	public String getCronologicaOuHistorica() {
		return cronologicaOuHistorica;
	}
	public void setCronologicaOuHistorica(String cronologicaOuHistorica) {
		this.cronologicaOuHistorica = cronologicaOuHistorica;
	}
	public String getCaracteristicasDaAmostragemDaPesquisa() {
		return caracteristicasDaAmostragemDaPesquisa;
	}
	public void setCaracteristicasDaAmostragemDaPesquisa(
			String caracteristicasDaAmostragemDaPesquisa) {
		this.caracteristicasDaAmostragemDaPesquisa = caracteristicasDaAmostragemDaPesquisa;
	}
	public String getAgencias() {
		return agencias;
	}
	public void setAgencias(String agencias) {
		this.agencias = agencias;
	}
	public void setCondicoesParaSubmissao(String condicoesParaSubmissao) {
		this.condicoesParaSubmissao = condicoesParaSubmissao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getCondicoesParaSubmissao() {
		return condicoesParaSubmissao;
	}
	public void setCondicoesParaSubmissão(String condicoesParaSubmissao) {
		this.condicoesParaSubmissao = condicoesParaSubmissao;
	}
	
	
	
}