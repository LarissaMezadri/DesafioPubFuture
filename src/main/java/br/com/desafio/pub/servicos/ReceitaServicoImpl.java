package br.com.desafio.pub.servicos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.repositorio.ReceitaRepositorio;
import br.com.desafio.pub.tipos.TipoReceita;
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
	public Receita salvar(Receita receita) {
		return repositorio.save(receita);
	}

	@Override
	public void excluir(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Receita> listar(BigDecimal valor, Date dataRecebimento, Date dataRecebimentoEsperado,
			TipoReceita tipoReceita, Conta conta) {
		return repositorio.findAll();
	}

	@Override
	public Receita buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
