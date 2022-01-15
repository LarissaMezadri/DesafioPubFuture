package br.com.desafio.pub.controlador;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.entidades.dto.ContaDTO;
import br.com.desafio.pub.servicos.ContaServico;

@RestController
public class ContaControlador {
	
	@Autowired
	private ContaServico servico;
	
	@GetMapping("conta/{id}")
	public Conta buscarPorId(@PathVariable Integer id) throws Exception {
		Conta retornar = servico.buscarPorId(id);
		if (retornar == null) {
			throw new Exception("CONTA INVÁLIDA!");
		}
		return retornar;
	}
	
	@PostMapping("conta")
	public Conta salvar(@RequestBody Conta conta) {
		return servico.salvar(conta);
	}
	
	@DeleteMapping ("conta/{id}")
	public void excluir(@PathVariable Integer id) {
		servico.excluir(id);
	}
	
	@GetMapping("conta/buscarPorFiltros")
	public List<Conta> buscarPorFiltros(@RequestBody ContaDTO contaFiltros) throws Exception{
		return servico.buscarPorFiltros(contaFiltros);
	}
	
	@GetMapping("conta/buscarSaldoConta/{id}")
	public BigDecimal buscarSaldoConta(@PathVariable Integer id) throws Exception {
		return servico.buscarSaldoConta(id);
	}
}
