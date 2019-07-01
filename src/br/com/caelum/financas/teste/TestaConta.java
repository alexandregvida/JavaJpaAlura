package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
//		conta.setTitular("Leonardo");
//		conta.setBanco("Caixa Economica Federal");
//		conta.setAgencia("123");
//		conta.setNumero("456");
//		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 6);
		
		System.out.println(conta);
		
		conta.setTitular("Alexandre Duarte");
		
		em.persist(conta);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
}
