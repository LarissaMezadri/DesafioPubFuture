package br.com.desafio.pub.repositorio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	
	
	@Query("select d from Despesa d "
			+ " where d.conta.id = ?1 "
			+ " and (?2 is null or d.dataPagamentoEsperado >= ?2) "
			+ " and (?3 is null or d.dataPagamentoEsperado <= ?3) "
			+ " order by d.dataPagamentoEsperado ")
	List<Despesa> buscarPorPeriodo(Integer contaId, LocalDate dataInicial, LocalDate dataFinal);



	@Query("select d from Despesa d "
			+ " where d.conta.id = ?1 "
			+ " and (?2 is null or d.tipoDespesa = ?2) "
			+ " order by d.tipoDespesa ")
	List<Despesa> buscarPorTipo(Integer contaId, TipoDespesa tipoDespesa);
	
	@Query("select sum(d.valor) from Despesa d "
			+ " where d.conta.id = ?1 "
			+ " group by d.conta.id ")
	BigDecimal buscarTotalPorConta(Integer contaId);

	


}
