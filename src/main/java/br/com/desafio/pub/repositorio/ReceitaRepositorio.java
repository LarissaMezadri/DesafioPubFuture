package br.com.desafio.pub.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.pub.entidades.Receita;
import br.com.desafio.pub.tipos.TipoReceita;

/**
 * Repositorio que se extende a receita. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface ReceitaRepositorio extends JpaRepository<Receita, Integer>{

	Receita save(TipoReceita tipoReceita);

}
