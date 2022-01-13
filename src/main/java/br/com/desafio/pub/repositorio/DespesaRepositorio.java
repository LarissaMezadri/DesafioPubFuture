package br.com.desafio.pub.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.pub.entidades.Despesa;
import br.com.desafio.pub.tipos.TipoDespesa;

/**
 * Repositorio que se extende a despesa. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface DespesaRepositorio extends JpaRepository<Despesa, Integer> {

	Despesa save(TipoDespesa tipoDespesa);

	


}
