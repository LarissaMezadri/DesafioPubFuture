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

	void excluir(Integer id);

	List<Receita> buscarPorPeriodo(ReceitaDTO receitaFiltros)throws Exception;
	
	List<Receita> buscarPorTipo(ReceitaDTO receitaFiltros)throws Exception;
	
	BigDecimal buscarTotalPorConta(Integer id)throws Exception;

	Receita buscarPorId(Integer id);

}
