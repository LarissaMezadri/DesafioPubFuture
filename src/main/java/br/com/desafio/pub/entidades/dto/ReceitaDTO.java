package br.com.desafio.pub.entidades.dto;

import java.time.LocalDate;

import br.com.desafio.pub.tipos.TipoReceita;

public class ReceitaDTO {

	private Integer contaId;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private TipoReceita tipoReceita;
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
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}
	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	public ReceitaDTO(Integer contaId, LocalDate dataInicial, LocalDate dataFinal, TipoReceita tipoReceita) {
		super();
		this.contaId = contaId;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.tipoReceita = tipoReceita;
	}
	
	public ReceitaDTO() {
		
	}
}
