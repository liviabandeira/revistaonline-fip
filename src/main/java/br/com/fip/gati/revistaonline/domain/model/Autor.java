package br.com.fip.gati.revistaonline.domain.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.fip.gati.revistaonline.domain.model.enums.SexoEnum;
import br.com.fip.gati.revistaonline.domain.model.enums.TitulacaoEnum;

@javax.persistence.Entity
@Table(name="autor")
public class Autor extends Entity {

	@Enumerated(EnumType.STRING)
	@Column(length=4)
	private TitulacaoEnum titulacao;
	
	@NotNull
	@Size(min=3, max=100)
	private String prenome;
	
	@NotNull
	@Size(min=3, max=100)
	private String nome;
	
	@NotNull
	@Size(min=3, max=100)
	private String sobrenome;
	
	@NotNull
	@Size(min=1, max=10)
	private String iniciais;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1)
	private SexoEnum sexo;
	
	@NotNull
	@Size(max=200)
	private String instituicao;
	
	@Size(max=255)
	private String assinatura;
	
	@Size(max=100)
	private String lattes;
	
	@Size(max=15)
	private String fone;

	@Size(max=15)
	private String celular;
	
	@Size(max=150)
	private String enderecoPostal;
	
	private String pais;
	
	@Size(max=255)
	private String resumoBiografia;
	
	@OneToOne(mappedBy="autor")
	private Avaliador avaliador;
	
	@OneToOne(mappedBy="autor")
	private Editor editor;
	
	
	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	public TitulacaoEnum getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(TitulacaoEnum titulacao) {
		this.titulacao = titulacao;
	}

	public String getPrenome() {
		return prenome;
	}

	public void setPrenome(String prenome) {
		this.prenome = prenome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIniciais() {
		return iniciais;
	}

	public void setIniciais(String iniciais) {
		this.iniciais = iniciais;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEnderecoPostal() {
		return enderecoPostal;
	}

	public void setEnderecoPostal(String enderecoPostal) {
		this.enderecoPostal = enderecoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getResumoBiografia() {
		return resumoBiografia;
	}

	public void setResumoBiografia(String resumoBiografia) {
		this.resumoBiografia = resumoBiografia;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	
	public boolean isAvaliador() {
		return avaliador != null;
	}
	
	public boolean isEditor() {
		return editor != null;
	}
	
}
