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
	
	/**
	 * Exclui uma conta
	 * @param id
	 */
	void excluir(Integer id);
	
	/**
	 * Lista as contas conforme os filtros informados
	 * @param contaFiltros
	 * @return
	 */
	List<Conta> buscarPorFiltros(ContaDTO contaFiltros);
	
	/**
	 * Busca o saldo da conta informada
	 * @param id
	 * @return
	 * @throws Exception
	 */
	BigDecimal buscarSaldoConta(Integer id) throws Exception;
	
	/**
	 * Tranferi saldo da contaOrigem para a contaDestino validando se é possivel fazer a operação pelo saldo e pela conta
	 * @param idContaPagadora
	 * @param valorTransferir
	 * @param idContaRecebedora
	 * @return
	 * @throws Exception
	 */
	boolean tranferirSaldo(Integer idContaPagadora, BigDecimal valorTransferir, Integer idContaRecebedora) throws Exception;
	
	/**
	 * Busca uma conta existente ou retorna que ela é inválida
	 * @param id
	 * @return
	 */
	Conta buscarPorId(Integer id);
	
}
