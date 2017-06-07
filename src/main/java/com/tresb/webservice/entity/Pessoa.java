package com.tresb.webservice.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pessoa {
	
	@Id 
	@GeneratedValue
	private Long Id;
	private String nome;
	private String cpf_cnpj;
	private String tipo_pessoa;
	private String telefone;
	@OneToMany
	private Collection<ContaBancaria> conta_bancaria;

}
