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
		return repositorio.buscarPorFiltros(contaFiltros.getContaId(), contaFiltros.getNome(), contaFiltros.getTipoConta(), contaFiltros.getInstituicaoFinanceira());
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
}
