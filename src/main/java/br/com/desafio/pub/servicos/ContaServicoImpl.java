package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.dto.ContaDTO;
import br.com.desafio.pub.repositorio.ContaRepositorio;
import lombok.AllArgsConstructor;

/**
 * Implementação da Conta Serviço com o retorno de um repositório.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Service
@AllArgsConstructor
public class ContaServicoImpl implements ContaServico {

	@Autowired
	private ContaRepositorio repositorio;

	@Override
	public Conta salvar(Conta conta) {
		return repositorio.save(conta);
	}

	@Override
	public void excluir(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Conta> buscarPorFiltros(ContaDTO contaFiltros) {
		return repositorio.buscarPorFiltros(contaFiltros.getContaId(), contaFiltros.getNome(),
				contaFiltros.getTipoConta(), contaFiltros.getInstituicaoFinanceira());
	}

	@Override
	public Conta buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public BigDecimal buscarSaldoConta(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		return repositorio.buscarSaldoConta(id);
	}

	@Override
	public boolean tranferirSaldo(Integer idContaPagadora, BigDecimal valorTransferir, Integer idContaRecebedora)
			throws Exception {
		validarTransferenciaConta(idContaPagadora, valorTransferir, idContaRecebedora);
		alteracaoDeSaldo(idContaPagadora, valorTransferir, false);
		alteracaoDeSaldo(idContaRecebedora, valorTransferir, true);
		return false;
	}
	
	public void alteracaoDeSaldo(Integer idConta, BigDecimal valorTransferir, boolean somando) {
		Conta contaOperacao = repositorio.findById(idConta).orElse(null);
		if (somando) {
			contaOperacao.setSaldo(contaOperacao.getSaldo().add(valorTransferir));
		} else {
			contaOperacao.setSaldo(contaOperacao.getSaldo().subtract(valorTransferir));
		}
		repositorio.save(contaOperacao);
	}

	public void validarTransferenciaConta(Integer idContaPagadora, BigDecimal valorTransferir,
			Integer idContaRecebedora) throws Exception {
		if (idContaPagadora == null) {
			throw new Exception("Você precisa informar uma conta de origem");
		}
		if (valorTransferir == null || valorTransferir.compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("Você precisa informar um valor válido maior do que zero");
		}
		if (idContaRecebedora == null) {
			throw new Exception("Você precisa informar uma conta de destino");
		}
		if (idContaPagadora.equals(idContaRecebedora)) {
			throw new Exception ("Você não pode fazer esta operação entre a mesma conta");
		}
		Conta contaPagadora = repositorio.findById(idContaPagadora).orElse(null);
		if (contaPagadora == null) {
			throw new Exception ("Você precisa informar uma conta de origem existente");
		}
		Conta contaRecebedora = repositorio.findById(idContaRecebedora).orElse(null);
		if (contaRecebedora == null) {
			throw new Exception ("Você precisa informar uma conta de destino existente");
		}
		if (contaPagadora.getSaldo().compareTo(valorTransferir) <0) {
			throw new Exception ("VOCÊ NÃO TEM SALDO DISPONIVEL PARA ESSA TRANSAÇÃO");
		}
	}

}
