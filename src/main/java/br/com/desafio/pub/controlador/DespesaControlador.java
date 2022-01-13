package br.com.desafio.pub.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.pub.entidades.Despesa;
import br.com.desafio.pub.servicos.DespesaServico;

@RestController
public class DespesaControlador {

	@Autowired
	private DespesaServico servico;

	@GetMapping("despesa/{id}")
	public Despesa buscarPorId(@PathVariable Integer id) throws Exception {
		Despesa retornar = servico.buscarPorId(id);
		if (retornar == null) {
			throw new Exception("DESPESA NÃO CADASTRADA!!");
		}
		return retornar;
	}

	@PostMapping("despesa")
	public Despesa salvar(@RequestBody Despesa despesa) {
		return servico.salvar(despesa);
	}

	@DeleteMapping("despesa/{id}")
	public void excluir(@PathVariable Integer id) {
		servico.excluir(id);
	}
}