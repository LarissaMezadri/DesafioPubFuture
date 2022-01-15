package br.com.desafio.pub.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.desafio.pub.tipos.TipoDespesa;

/**
 *  Entidade responsável pelas despesas.
 *  
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Entity
@Table(name = "despesas")
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "datapagamento", nullable = false)
	private LocalDate dataPagamento;
	
	@Column(name = "datapagamentoesperado", nullable = false)
	private LocalDate dataPagamentoEsperado;
	
	@ManyToOne
	@JoinColumn(name = "contaid", nullable = false)
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipodespesa", nullable = false)
	private TipoDespesa tipoDespesa;

	public Despesa(Integer id, BigDecimal valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, Conta conta,
			TipoDespesa tipoDespesa) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.conta = conta;
		this.tipoDespesa = tipoDespesa;
	}

	public Despesa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(LocalDate dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

}