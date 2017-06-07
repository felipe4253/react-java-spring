package com.tresb.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class OperacaoFinanceira {

	public OperacaoFinanceira(){
	}
	
	private @Id @GeneratedValue Long Id;
	
	private Integer tipo_operacao;
	
	private Double valor;
	
	@ManyToOne
	private ContaBancaria contaBancaria;
	
	public OperacaoFinanceira(Integer tipoOperacao, Double valor, ContaBancaria contaBancaria){
		this.tipo_operacao = tipoOperacao;
		this.valor = valor;
		this.contaBancaria = contaBancaria;
	}
	
}
