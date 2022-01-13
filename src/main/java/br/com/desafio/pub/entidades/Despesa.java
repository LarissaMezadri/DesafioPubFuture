package br.com.desafio.pub.entidades;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "despesa")
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "datapagamento", nullable = false)
	private Date dataPagamento;
	
	@Column(name = "datapagamentoesperado", nullable = false)
	private Date dataPagamentoEspePrado;
	
	@ManyToOne
	@JoinColumn(name = "contaid", nullable = false)
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipodespesa", nullable = false)
	private TipoDespesa tipoDespesa;

	public Despesa(Integer id, BigDecimal valor, Date dataPagamento, Date dataPagamentoEsperado, Conta conta,
			TipoDespesa tipoDespesa) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEspePrado = dataPagamentoEsperado;
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

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPagamentoEspePrado() {
		return dataPagamentoEspePrado;
	}

	public void setDataPagamentoEspePrado(Date dataPagamentoEspePrado) {
		this.dataPagamentoEspePrado = dataPagamentoEspePrado;
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