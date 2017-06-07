package com.tresb.webservice.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(generator = "increment") 
	@GenericGenerator( name = "increment", strategy = "increment")
	private Long id;
	
	private String nome;
	
	private String tipo_pessoa;
	
	private String telefone;
	
	private String cpfCnpj;
	
	



	@OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<ContaBancaria> contasBancarias = new HashSet<>();
	
	public String getNome() {
		return nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo_pessoa() {
		return tipo_pessoa;
	}
	public void setTipo_pessoa(String tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Set<ContaBancaria> getContasBancarias() {
		return contasBancarias;
	}
	
	
	public void add(ContaBancaria contaBancaria){
		contasBancarias.add(contaBancaria);
	}
	
	
	
	
	
}
