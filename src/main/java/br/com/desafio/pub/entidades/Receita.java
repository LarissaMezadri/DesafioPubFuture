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

import br.com.desafio.pub.tipos.TipoReceita;

/**
 * Entidade responsável pelas receitas.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Entity
@Table(name = "receitas")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "datarecebimento", nullable = false)
	private LocalDate dataRecebimento;
	
	@Column(name = "datarecebimentoesperado", nullable = false)
	private LocalDate dataRecebimentoEsperado;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "contaid", nullable = false)
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tiporeceita", nullable = false)
	private TipoReceita tipoReceita;
	
	public Receita(Integer id, BigDecimal valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, String descricao, Conta conta, TipoReceita tipoReceita ) {
		super ();
		this.id = id;
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
		
	}
		public Receita () {
	
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
		public LocalDate getDataRecebimento() {
			return dataRecebimento;
		}
		public void setDataRecebimento(LocalDate dataRecebimento) {
			this.dataRecebimento = dataRecebimento;
		}
		public LocalDate getDataRecebimentoEsperado() {
			return dataRecebimentoEsperado;
		}
		public void setDataRecebimentoEsperado(LocalDate dataRecebimentoEsperado) {
			this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Conta getConta() {
			return conta;
		}
		public void setConta(Conta conta) {
			this.conta = conta;
		}
		public TipoReceita getTipoReceita() {
			return tipoReceita;
		}
		public void setTipoReceita(TipoReceita tipoReceita) {
			this.tipoReceita = tipoReceita;
		}

		
}