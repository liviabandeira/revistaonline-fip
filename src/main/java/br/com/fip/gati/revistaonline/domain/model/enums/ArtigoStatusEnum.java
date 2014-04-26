package br.com.fip.gati.revistaonline.domain.model.enums;

public enum ArtigoStatusEnum {

	P("PENDENTE"),
	E("EM REVISAO/AVALIACAO"),
	A("APROVADO"),
	R("REPROVADO");
	
	private String descricao;
	
	private ArtigoStatusEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
