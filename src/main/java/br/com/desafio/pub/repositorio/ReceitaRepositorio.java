package br.com.desafio.pub.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafio.pub.entidades.Receita;

/**
 * Repositorio que se extende a receita. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface ReceitaRepositorio extends JpaRepository<Receita, Integer>{

	@Query("select r from Receita r "
			+ " where r.conta.id = ?1 "
			+ " and (?2 is null or r.dataRecebimentoEsperado >= ?2) "
			+ " and (?3 is null or r.dataRecebimentoEsperado <= ?3) "
			+ " order by r.dataRecebimentoEsperado ")
	List<Receita> buscarPorPeriodo(Integer contaId, LocalDate dataInicial, LocalDate dataFinal);

}
