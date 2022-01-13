package br.com.desafio.pub.tipos;

/**
 * Classe que define os tipos de receita. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */
public enum TipoReceita {

	SALARIO("Salário"), PRESENTE("Presente"), PREMIO("Prêmio");

	private TipoReceita(String descricao) {
		this.descricao = descricao;

	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}
