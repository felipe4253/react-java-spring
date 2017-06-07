package com.tresb.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pessoa {

	public Pessoa(){
		
	}
	private @Id @GeneratedValue Long Id;
	
	private String nome;
	
	private String cpf_cnpj;
	
	private String tipo_pessoa;
	
	private String telefone;
	
	public Pessoa(String nome, String cpf_cnpj, String tipo_pessoa, String telefone){
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.tipo_pessoa = tipo_pessoa;
		this.telefone = telefone;
	}
	
}
