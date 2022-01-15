package br.com.desafio.pub.entidades.dto;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.tipos.TipoConta;

public class ContaDTO {

	private String nome;
	private TipoConta tipoConta;
	private String instituicaoFinanceira;
	private Conta contaId;
	
	
	
	public Conta getContaId() {
		return contaId;
	}

	public void setContaId(Conta contaId) {
		this.contaId = contaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public ContaDTO(Conta contaId, String nome, TipoConta tipoConta, String instituicaoFinanceira) {
		super();
		this.contaId = contaId;
		this.nome = nome;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public ContaDTO() {

	}

}
