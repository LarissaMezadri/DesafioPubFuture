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
	
	/**
	 * Exclui uma despesa
	 * @param id
	 */
	void excluir(Integer id);
	
	/**
	 * Lista uma despesa pelo filtro de periodo data inicial e data final
	 * @param despesaFiltros
	 * @return
	 * @throws Exception
	 */
	List<Despesa> buscarPorPeriodo(DespesaDTO despesaFiltros)throws Exception;
	
	/**
	 * Lista uma despesa conforme o tipo de despesa informado 
	 * @param despesaFiltros
	 * @return
	 * @throws Exception
	 */
	List<Despesa> buscarPorTipo(DespesaDTO despesaFiltros)throws Exception;
	
	/**
	 * Busca o total de despesas pela conta 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	BigDecimal buscarTotalPorConta(Integer id)throws Exception;
	
	/**
	 * Busca uma despesa
	 * @param id
	 * @return
	 */
	Despesa buscarPorId(Integer id);
}
