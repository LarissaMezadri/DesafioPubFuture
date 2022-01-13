package br.com.desafio.pub.tipos;

/**
 * Classe que define os tipos de despesas.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */
public enum TipoDespesa {

	ALIMENTACAO("Alimentação"),
	SAUDE("Saúde"), 
	TRANSPORTE("Transporte"), 
	EDUCACAO("Educação"), 
	LAZER("Lazer"),
	MORADIA("Moradia"),
	VESTUARIO("Vestuário");

	private TipoDespesa(String descricao) {
		this.descricao = descricao;

	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	

}
