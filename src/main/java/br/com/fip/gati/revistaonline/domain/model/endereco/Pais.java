package br.com.fip.gati.revistaonline.domain.model.endereco;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@javax.persistence.Entity
@Table(name="pais")
public class Pais {

	@NotNull
	@Size(min=2, max=2)
	@Id
	private String iso;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String nomeExibivel;
	
	private String iso3;
	
	private String numcode;

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeExibivel() {
		return nomeExibivel;
	}

	public void setNomeExibivel(String nomeExibivel) {
		this.nomeExibivel = nomeExibivel;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getNumcode() {
		return numcode;
	}

	public void setNumcode(String numcode) {
		this.numcode = numcode;
	}
	
}
