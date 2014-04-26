package br.com.fip.gati.revistaonline.domain.model.enums;

public enum AvaliacaoStatusEnum {

	P("PENDENTE"),
	A("AVALIADO");
	
	private String descricao;
	
	private AvaliacaoStatusEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
