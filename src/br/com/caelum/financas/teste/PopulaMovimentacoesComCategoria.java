package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.Conta.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		
		
		Categoria categoria1 = new Categoria("viagem");
		//catetoria1.setNome("viagem");
		
		Categoria categoria2 = new Categoria("negócios");
		//categoria2.setNome("negócios");
		
		Conta conta = new Conta();
		//conta.setId(12);
		
		conta = em.find(Conta.class, 1);

		System.out.println(conta);
		
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH,1);
		
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(amanha);
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("300.0"));
		movimentacao1.setCategoria(Arrays.asList(categoria1,categoria2));
		
		movimentacao1.setConta(conta);

		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(amanha); 
		movimentacao2.setDescricao("Compensação Viajem RJ");
		movimentacao2.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao2.setValor(new BigDecimal("600.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria1,categoria2));
		
		movimentacao2.setConta(conta);
		

		//conta.setTitular("Leonardo 12");
		
		
		em.persist(conta);
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
