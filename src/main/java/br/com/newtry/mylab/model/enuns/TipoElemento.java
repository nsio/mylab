package br.com.newtry.mylab.model.enuns;

public enum TipoElemento {

	METAIS_ALCALINOS("Metais alcalinos"),
	METAIS_REPRESENTATIVOS("Metais representativos"),
	METAIS_ALCALINO_TERRESO("Metais alcalino-terrosos"),
	SEMI_METAIS("Semi-metais"),
	METAIS_TRANSICAO("Metais de transição"),
	NAO_METAIS("Não-metais"),
	LANTANIDEOS("Lantanídeos"),
	HALOGENIOS("Halogênios"),
	ACTINIDEOS("Actinídeos"),
	GASES_NOBRES("Gases nobres");
	
	private String descricao;
	
	TipoElemento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
