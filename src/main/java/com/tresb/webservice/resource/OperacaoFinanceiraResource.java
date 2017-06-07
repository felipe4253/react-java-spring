package com.tresb.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.OperacaoFinanceira;
import com.tresb.webservice.repository.ContaBancariaRepository;
import com.tresb.webservice.repository.OperacaoFinanceiraRepository;

@RestController
public class OperacaoFinanceiraResource {
	
	@Autowired
	OperacaoFinanceiraRepository repository;
	
	@Autowired
	ContaBancariaRepository repositoryContaBancaria;
	
	@RequestMapping(value="/operacoes_financeira", method = RequestMethod.GET)
	public List<OperacaoFinanceira> listar() {
		return (List<OperacaoFinanceira>) repository.findAll();
	}
	
	@RequestMapping(value="/operacao_financeira/{id}", method = RequestMethod.GET)
	public OperacaoFinanceira findById(@PathVariable("id") long id) {
		return repository.findOne(id);
	}

	@RequestMapping(value="/operacao/conta/{numero}/valor/{valor}/operacao/{tipo}", method = RequestMethod.GET)
	public ContaBancaria operacao(@PathVariable("numero") Integer numero, @PathVariable("valor") Double valor, @PathVariable("tipo") Integer tipo) {
		
		OperacaoFinanceira operacaoFinanceira = new OperacaoFinanceira();
		ContaBancaria contaBancaria = repositoryContaBancaria.buscarConta(numero);
		
		Double saldo = contaBancaria.getSaldo_atual();
		if(tipo == 1){
			saldo += valor;			
		}else if(tipo == 2){
			saldo -= valor;
		}
		operacaoFinanceira.setTipo_operacao(tipo);
		operacaoFinanceira.setContaBancaria(contaBancaria);
		operacaoFinanceira.setValor(valor);
		
		contaBancaria.setSaldo_atual(saldo);
		repositoryContaBancaria.save(contaBancaria);
		repository.save(operacaoFinanceira);
		
		return contaBancaria;
	}
	
}
