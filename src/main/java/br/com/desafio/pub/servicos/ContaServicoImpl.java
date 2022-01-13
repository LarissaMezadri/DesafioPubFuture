package br.com.desafio.pub.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.repositorio.ContaRepositorio;
import br.com.desafio.pub.tipos.TipoConta;
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
	public List<Conta> listar(String nome, TipoConta tipoConta, String instituicaoFinanceira) {
		return repositorio.findAll();
	}

	@Override
	public Conta buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
}
