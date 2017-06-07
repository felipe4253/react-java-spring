package com.tresb.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ContaBancaria {

	public ContaBancaria(){
		
	}
	
	private @Id @GeneratedValue Long Id;
	
	private Integer numero_conta;
	
	private Double saldo_atual;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public ContaBancaria(Integer numeroConta, Double saldoAtual, Pessoa pessoa){
		this.numero_conta = numeroConta;
		this.saldo_atual = saldoAtual;
		this.pessoa = pessoa;
	}
	
}
