package br.com.desafio.pub.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.pub.entidades.Conta;
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
	
	

}
