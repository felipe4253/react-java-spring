package com.tresb.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author weslei.dias
 */

@Entity
public class Funcionario {

	private @Id @GeneratedValue Long Id;
	private String primeiroNome;
	private String ultimoNome;
	private String cargo;

	private Funcionario() 
	{
		
	}

	public Funcionario(String firstName, String lastName, String description) 
	{
		this.primeiroNome = firstName;
		this.ultimoNome = lastName;
		this.cargo = description;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
	
}