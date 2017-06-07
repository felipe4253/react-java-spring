package com.tresb.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author weslei.dias
 */
@Data
@Entity
public class Funcionario {

	private @Id @GeneratedValue Long Id;
	private String primeiroNome;
	private String ultimoNome;
	private String cargo;

	public Funcionario(String firstName, String lastName, String description){
		this.primeiroNome = firstName;
		this.ultimoNome = lastName;
		this.cargo = description;
	}
}