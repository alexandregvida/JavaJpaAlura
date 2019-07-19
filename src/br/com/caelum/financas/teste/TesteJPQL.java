package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Conta.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta = em.find(Conta.class, 1);
		
		//String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo  " + " order by m.valor desc";

		//Soma
		//String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo";
		
		
		//Media
		//String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo";
		
		//Maior Valor
		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo";


		
		Query query  = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		BigDecimal soma = (BigDecimal) query .getSingleResult();
		
		System.out.println("A resultado da query è : " + soma);
		
		em.getTransaction().commit();

		em.close();
		
		
	}
	
	
}
