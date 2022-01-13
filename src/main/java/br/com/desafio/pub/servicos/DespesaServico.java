package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.Despesa;
import br.com.desafio.pub.tipos.TipoDespesa;

public interface DespesaServico {

	/**
	 * Inclui ou altera uma despesa existente
	 * @param despesa
	 * @return nova despesa
	 */
	Despesa salvar(Despesa despesa);

	void excluir(Integer id);
	
	List<Despesa> listar(BigDecimal valor, Date dataPagamento, Date dataPagamentoEsperado, TipoDespesa tipoDespesa, Conta conta);
	
	Despesa buscarPorId(Integer id);
}
