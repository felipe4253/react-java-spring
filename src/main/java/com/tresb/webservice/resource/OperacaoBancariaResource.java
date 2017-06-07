package com.tresb.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Funcionario;
import com.tresb.webservice.entity.OperacaoFinanceira;
import com.tresb.webservice.repository.ContaRepository;
import com.tresb.webservice.repository.OperacaoBancariaRepository;

@RestController
public class OperacaoBancariaResource {
	@Autowired
	OperacaoBancariaRepository repository;
	
	@Autowired
	ContaRepository contaRepository;
	
	
	@RequestMapping(value="/operacoesBancarias", method = RequestMethod.GET)
	public List<OperacaoFinanceira> listar() {
		return (List<OperacaoFinanceira>) repository.findAll();
	}
	
	@RequestMapping(value="/operacaoBancaria/{id}", method = RequestMethod.GET)
	public OperacaoFinanceira findById(@PathVariable("id") long id) {
		return repository.findOne(id);
	}
	
	
	@RequestMapping(value="/operacaoBancaria/numeroConta/{numeroconta}/tipooperacao/{tipooperacao}/valor/{valor}", method = RequestMethod.GET)
	public ContaBancaria realizarOperacao(@PathVariable("numeroconta") String numeroconta, @PathVariable("tipooperacao") String tipooperacao, @PathVariable("valor") double valor) {
		ContaBancaria conta = contaRepository.findByNumeroConta(numeroconta);
		OperacaoFinanceira operacaoFinanceira = new OperacaoFinanceira();
		operacaoFinanceira.setTipo_operacao(tipooperacao);
		operacaoFinanceira.setValor(valor);
		operacaoFinanceira.setContaBancaria(conta);

		if(operacaoFinanceira.getTipo_operacao().equalsIgnoreCase("credito") ){
			conta.setSaldo_atual(conta.getSaldo_atual() + operacaoFinanceira.getValor());
		}else{
			conta.setSaldo_atual(conta.getSaldo_atual() - operacaoFinanceira.getValor());
		}
		repository.save(operacaoFinanceira);
		contaRepository.save(conta);
		return conta;
		
		
		
	}
	
	
	

	
	
}
