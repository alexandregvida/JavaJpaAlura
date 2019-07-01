package br.com.caelum.financas.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.caelum.financas.modelo.Conta.Conta;

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private String profissao;
	private String endereco;
	
	@OneToOne
	private Conta conta;
	
}
