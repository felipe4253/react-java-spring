package com.tresb.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class OperacaoFinanceira {
	
	@Id 
	@GeneratedValue
	private Long Id;
	private String tipo_operacao;
	private Double valor;
	//private Long conta_bancaria_id;
	
	@ManyToOne
	private ContaBancaria conta_bancaria;

}
