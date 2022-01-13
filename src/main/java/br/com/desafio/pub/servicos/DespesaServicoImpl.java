package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.Despesa;
import br.com.desafio.pub.repositorio.DespesaRepositorio;
import br.com.desafio.pub.tipos.TipoDespesa;
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
	public Despesa salvar(Despesa despesa) {
		return repositorio.save(despesa);
	}

	@Override
	public void excluir(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Despesa> listar(BigDecimal valor, Date dataPagamento, Date dataPagamentoEsperado,
			TipoDespesa tipoDespesa, Conta conta) {
		return repositorio.findAll();
	}

	@Override
	public Despesa buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
		
	}
}