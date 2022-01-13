package br.com.desafio.pub.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.servicos.ReceitaServico;

@RestController
public class ReceitaControlador {

	@Autowired
	private ReceitaServico servico;

	@GetMapping("receita/{id}")
	public Receita buscarPorId(@PathVariable Integer id) throws Exception {
		Receita retornar = servico.buscarPorId(id);
		if (retornar == null) {
			throw new Exception("RECEITA NÃO CADASTRADA!!");
		}
		return retornar;
	}

	@PostMapping("receita")
	public Receita salvar(@RequestBody Receita receita) {
		return servico.salvar(receita);
	}

	@DeleteMapping("receita/{id}")
	public void excluir(@PathVariable Integer id) {
		servico.excluir(id);
	}
}
