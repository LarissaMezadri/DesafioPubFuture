package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.util.List;

import br.com.desafio.pub.entidades.Despesa;
import br.com.desafio.pub.entidades.dto.DespesaDTO;

public interface DespesaServico {

	/**
	 * Inclui ou altera uma despesa existente
	 * @param despesa
	 * @return nova despesa
	 */
	Despesa salvar(Despesa despesa)throws Exception;

	void excluir(Integer id);
	
	List<Despesa> buscarPorPeriodo(DespesaDTO despesaFiltros)throws Exception;
	
	List<Despesa> buscarPorTipo(DespesaDTO despesaFiltros)throws Exception;
	
	BigDecimal buscarTotalPorConta(Integer id)throws Exception;
	
	Despesa buscarPorId(Integer id);
}
