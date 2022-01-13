package br.com.desafio.pub.entidades;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.desafio.pub.tipos.TipoConta;


/**
 *  Entidade responsável pelas contas.
 *  
 * @author Larissa.Mezadri.Da.Silva
 *
 */
@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "saldo", nullable = false)
	private BigDecimal saldo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoconta", nullable = false)
	private TipoConta tipoConta;
	
	@Column(name = "instituicaofinanceira", nullable = false)
	private String instituicaoFinanceira;
	
	@OneToMany(mappedBy = "conta")
	private Set<Receita> receitas;
	
	@OneToMany(mappedBy = "conta")
	private Set<Despesa> despesas;
	
	public Conta(Integer id, String nome, BigDecimal saldo, TipoConta tipoConta, String instituicaoFinanceira) {
		super();
		this.id = id;
		this.nome = nome;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	
	public Conta() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
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
	
	

}
