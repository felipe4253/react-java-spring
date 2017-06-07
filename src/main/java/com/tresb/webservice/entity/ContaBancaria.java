package com.tresb.webservice.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ContaBancaria {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	private String numeroConta;
	
	private double saldo_atual;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<OperacaoFinanceira> operacoesFinanceiras = new HashSet<>();

	@ManyToOne
	private Pessoa pessoa;

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numero_conta) {
		this.numeroConta = numero_conta;
	}

	public double getSaldo_atual() {
		return saldo_atual;
	}

	public void setSaldo_atual(double saldo_atual) {
		this.saldo_atual = saldo_atual;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Set<OperacaoFinanceira> getOperacoesFinanceiras() {
		return operacoesFinanceiras;
	}

	public void setOperacoesFinanceiras(Set<OperacaoFinanceira> operacoesFinanceiras) {
		this.operacoesFinanceiras = operacoesFinanceiras;
	}
	
	public void add(OperacaoFinanceira operacaoFinanceira){
		operacoesFinanceiras.add(operacaoFinanceira);
	}
	

}
