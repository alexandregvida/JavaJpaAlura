package br.com.caelum.financas.teste;

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
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo  " + " order by m.valor desc";
		
		Query query  = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		List<Movimentacao> resultados = query.getResultList();		
		
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: " + movimentacao.getDescricao() + " Valor: " + movimentacao.getValor() + " Conta.ID " + movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		
		em.close();
		
		
	}
	
	
}
