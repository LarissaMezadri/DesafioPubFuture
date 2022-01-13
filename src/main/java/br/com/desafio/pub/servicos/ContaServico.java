package br.com.desafio.pub.servicos;

import java.util.List;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.tipos.TipoConta;

public interface ContaServico {

	/**
	 * Inclui ou altera uma conta existente
	 * @param conta
	 * @return nova conta
	 */
	Conta salvar(Conta conta);

	void excluir(Integer id);
	
	List<Conta> listar(String nome, TipoConta tipoConta, String instituicaoFinanceira);
	
	Conta buscarPorId(Integer id);
	
}
