package br.com.desafio.pub.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.pub.entidades.Conta;

/**
 * Repositorio que se extende a conta. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Integer> {
	
	

}
