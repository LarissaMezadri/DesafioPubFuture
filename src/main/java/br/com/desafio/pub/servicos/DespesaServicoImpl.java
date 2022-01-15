package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.pub.entidades.Despesa;
import br.com.desafio.pub.entidades.dto.DespesaDTO;
import br.com.desafio.pub.repositorio.DespesaRepositorio;
import lombok.AllArgsConstructor;

/**
 * Implementação da Despesa Serviço com o retorno de um repositório.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Service
@AllArgsConstructor
public class DespesaServicoImpl implements DespesaServico {

	@Autowired
	private DespesaRepositorio repositorio;

	@Override
	public Despesa salvar(Despesa despesa) throws Exception {
		validarAlteracaoDespesa(despesa);
		return repositorio.save(despesa);
	}

	public void validarAlteracaoDespesa(Despesa despesa) throws Exception {
		if (despesa.getId() != null) {
			Despesa despesaSalva = repositorio.findById(despesa.getId()).orElse(null);
			if (!despesa.getValor().equals(despesaSalva.getValor())) {
				throw new Exception("Você não pode alterar o valor de uma despesa que já está cadastrada");
			}
		}

	}

	@Override
	public void excluir(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Despesa> buscarPorPeriodo(DespesaDTO despesaFiltros) throws Exception {
		if (despesaFiltros.getContaId() == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		if (despesaFiltros.getDataInicial() != null && despesaFiltros.getDataFinal() != null
				&& despesaFiltros.getDataInicial().isAfter(despesaFiltros.getDataFinal())) {
			throw new Exception("A data inicial não pode ser maior que a data final");
		}
		return repositorio.buscarPorPeriodo(despesaFiltros.getContaId(), despesaFiltros.getDataInicial(),
				despesaFiltros.getDataFinal());
	}

	@Override
	public List<Despesa> buscarPorTipo(DespesaDTO despesaFiltros) throws Exception {
		if (despesaFiltros.getContaId() == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		return repositorio.buscarPorTipo(despesaFiltros.getContaId(), despesaFiltros.getTipoDespesa());
	}

	@Override
	public BigDecimal buscarTotalPorConta(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Você precisa informar uma conta");
		}
		return repositorio.buscarTotalPorConta(id);
	}

	@Override
	public Despesa buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);

	}
}