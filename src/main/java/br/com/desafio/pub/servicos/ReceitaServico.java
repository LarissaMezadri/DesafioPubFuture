package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.util.List;

import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.entidades.dto.ReceitaDTO;

public interface ReceitaServico {

	/**
	 * Inclui ou altera uma receita existente
	 * 
	 * @param receita
	 * @return nova receita
	 * @throws Exception 
	 */
	Receita salvar(Receita receita) throws Exception;
	
	/**
	 * Exclui uma receita
	 * @param id
	 */
	void excluir(Integer id);
	
	/**
	 * Lista uma receita por periodo data inicial e data final
	 * @param receitaFiltros
	 * @return
	 * @throws Exception
	 */
	List<Receita> buscarPorPeriodo(ReceitaDTO receitaFiltros)throws Exception;
	
	/**
	 * Lista uma receita por tipo de receita 
	 * @param receitaFiltros
	 * @return
	 * @throws Exception
	 */
	List<Receita> buscarPorTipo(ReceitaDTO receitaFiltros)throws Exception;
	
	/**
	 * Busca 
	 * @param id
	 * @returno total de receitas
	 * @throws Exception
	 */
	BigDecimal buscarTotalPorConta(Integer id)throws Exception;
	
	/**
	 * Busca uma receita
	 * @param id
	 * @return
	 */
	Receita buscarPorId(Integer id);

}
