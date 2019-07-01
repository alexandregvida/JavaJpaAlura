package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import com.sun.imageio.plugins.common.BogusColorSpace;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Conta.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	
	
	public static void main(String[] args) {
		Conta conta = new Conta ();
			
		conta.setId(5);
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Super Mercado");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("350.00"));
		
		movimentacao.setConta(conta);
		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//em.find(Conta.class, 4);
		//em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
