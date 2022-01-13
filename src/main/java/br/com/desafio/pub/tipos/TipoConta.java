package br.com.desafio.pub.tipos;

/**
 * Classe que define os tipos de conta.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */
public enum TipoConta {
	
	CONTA_POUPANCA ("Conta poupança"), 
	CONTA_CORRENTE ("Conta corrente"), 
	CONTA_CARTEIRA ("Conta Carteira");

	private TipoConta(String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
}
