package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.util.List;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.dto.ContaDTO;

public interface ContaServico {

	/**
	 * Inclui ou altera uma conta existente
	 * @param conta
	 * @return nova conta
	 */
	Conta salvar(Conta conta);

	void excluir(Integer id);
	
	List<Conta> buscarPorFiltros(ContaDTO contaFiltros);
	
	BigDecimal buscarSaldoConta(Integer id) throws Exception;
	
	boolean tranferirSaldo(Integer idContaPagadora, BigDecimal valorTransferir, Integer idContaRecebedora) throws Exception;
	
	Conta buscarPorId(Integer id);
	
}
