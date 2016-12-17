package br.com.newtry.mylab.model.enuns;

public enum TipoArea {
	
	TERRA("Terra"),
	AGUA("Água");
	
	private String descricao;
	
	TipoArea(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
