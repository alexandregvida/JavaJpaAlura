package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sun.xml.internal.stream.Entity;

import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Conta.Conta;

public class MovimentacaoDao {
	
	private EntityManager em;

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {

		// String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and
		// m.tipo = :pTipo " + " order by m.valor desc";

		// Soma
		// String jpql = "select sum(m.valor) from Movimentacao m where m.conta =
		// :pConta" + " and m.tipo = :pTipo";

		// Media
		// String jpql = "select avg(m.valor) from Movimentacao m where m.conta =
		// :pConta" + " and m.tipo = :pTipo";

		// Maior Valor
		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		return query.getResultList();
		
	}

}
