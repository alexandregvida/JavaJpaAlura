package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Conta.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = manager.find(Conta.class, 2);
		
		String jpql = "select          avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo group by day(data)";
	  //String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo group by m.data";


		TypedQuery<Double> query = manager
				.createQuery(jpql,Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = (List<Double>) query.getResultList();
		
		for (Double double1 : medias) {
			System.out.println("Medias do dia " + double1);
		}

	}

}
