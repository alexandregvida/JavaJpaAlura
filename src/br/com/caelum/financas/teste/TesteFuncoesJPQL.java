package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Conta.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = new Conta();
		conta = em.find(Conta.class, 1);

		TypedQuery<Double> typedQUery = em.createNamedQuery("MediasPorDiaETipo", Double.class);

		typedQUery.setParameter("pConta", conta);
		typedQUery.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Double> resultados = typedQUery.getResultList();

		for (Double double1 : resultados) {
			System.out.println("Resultados: "+ double1);

		}

		em.getTransaction().commit();

		em.close();

	}

}
