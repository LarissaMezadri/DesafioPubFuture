package br.com.desafio.pub.repositorio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafio.pub.entidades.Conta;
import br.com.desafio.pub.tipos.TipoConta;

/**
 * Repositorio que se extende a conta. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Integer> {
	
	@Query("select c from Conta  c "
			+ " where (:contaId is null or c.id = :contaId )"
			+ " and (:nome is null or c.nome like concat('%',:nome,'%')) "
			+ " and (:tipoConta is null or c.tipoConta = :tipoConta) "
			+ " and (:instFin is null or c.instituicaoFinanceira like concat ('%',:instFin ,'%')) "
			+ " order by c.id ")
	List<Conta> buscarPorFiltros(@Param("contaId") Conta contaId, 
								 @Param("nome") String nome,
								 @Param("tipoConta") TipoConta tipoConta, 
								 @Param("instFin") String instituicaoFinanceira);

	@Query("select c.saldo from Conta c "
			+ " where c.id = ?1 ")
	BigDecimal buscarSaldoConta(Integer contaId);

}
