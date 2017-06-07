package com.tresb.webservice.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class ContaBancaria {

	@Id 
	@GeneratedValue
	private Long Id;
	private String numero_conta;
	private Double saldo_atual;

	@ManyToOne
	private Pessoa pessoa;
	
	@OneToMany
	private Collection<OperacaoFinanceira> operacao_financeida;
	
}
