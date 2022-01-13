package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.tipos.TipoReceita;

public interface ReceitaServico {

	/**
	 * Inclui ou altera uma receita existente
	 * 
	 * @param receita
	 * @return nova receita
	 */
	Receita salvar(Receita receita);

	void excluir(Integer id);

	List<Receita> listar(BigDecimal valor, Date dataRecebimento, Date dataRecebimentoEsperado, TipoReceita tipoReceita,
			Conta conta);

	Receita buscarPorId(Integer id);

}
