package br.com.desafio.pub.servicos;

import java.util.List;

import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.entidades.dto.ReceitaDTO;

public interface ReceitaServico {

	/**
	 * Inclui ou altera uma receita existente
	 * 
	 * @param receita
	 * @return nova receita
	 */
	Receita salvar(Receita receita);

	void excluir(Integer id);

	List<Receita> listar(ReceitaDTO receitaFiltros)throws Exception;

	Receita buscarPorId(Integer id);

}
