package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.entidades.dto.ReceitaDTO;
import br.com.desafio.pub.repositorio.ReceitaRepositorio;
import lombok.AllArgsConstructor;

/**
 * Implementação da Receita Serviço com o retorno de um repositório.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Service
@AllArgsConstructor

public class ReceitaServicoImpl implements ReceitaServico {

	@Autowired
	private ReceitaRepositorio repositorio;

	@Override
	public Receita salvar(Receita receita) throws Exception {
		validarAlteracaoReceita(receita);
		return repositorio.save(receita);
	}
	
	public void validarAlteracaoReceita (Receita receita) throws Exception {
		if (receita.getId() != null ) {
			Receita receitaSalva = repositorio.findById(receita.getId()).orElse(null);
			if (receita.getValor() != receitaSalva.getValor()) {
				throw new Exception("Você não pode alterar o valor de uma receita que já está cadastrada");
			}
		}
	}

	@Override
	public void excluir(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Receita> buscarPorPeriodo(ReceitaDTO receitaFiltros) throws Exception {
		if (receitaFiltros.getContaId() == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		if (receitaFiltros.getDataInicial() != null && receitaFiltros.getDataFinal() != null
				&& receitaFiltros.getDataInicial().isAfter(receitaFiltros.getDataFinal())) {
			throw new Exception("A data inicial não pode ser maior que a data final");
		}
		return repositorio.buscarPorPeriodo(receitaFiltros.getContaId(), receitaFiltros.getDataInicial(),
				receitaFiltros.getDataFinal());
	}

	@Override
	public List<Receita> buscarPorTipo(ReceitaDTO receitaFiltros) throws Exception {
		if (receitaFiltros.getContaId() == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		return repositorio.buscarPorTipo(receitaFiltros.getContaId(), receitaFiltros.getTipoReceita());
	}

	@Override
	public Receita buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public BigDecimal buscarTotalPorConta(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		return repositorio.buscarTotalPorConta(id);
	}

}
