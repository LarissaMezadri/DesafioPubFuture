package br.com.desafio.pub.entidades.dto;

import java.time.LocalDate;

import br.com.desafio.pub.tipos.TipoDespesa;

public class DespesaDTO {

	private Integer contaId;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private TipoDespesa tipoDespesa;
	public Integer getContaId() {
		return contaId;
	}
	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public DespesaDTO(Integer contaId, LocalDate dataInicial, LocalDate dataFinal, TipoDespesa tipoDespesa) {
		super();
		this.contaId = contaId;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.tipoDespesa = tipoDespesa;
	}
	
	public DespesaDTO() {
		
	}
}
