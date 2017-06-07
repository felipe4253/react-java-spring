package com.tresb.webservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Funcionario;
import com.tresb.webservice.entity.OperacaoFinanceira;
import com.tresb.webservice.entity.Pessoa;

/**
 * @author weslei.dias
 */
@Component
public class DatabaseLoader implements CommandLineRunner 
{
	private final FuncionarioRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	
	@Autowired
	private OperacaoBancariaRepository operacaoBancariaRepository;
	
	
	
	@Autowired
	public DatabaseLoader(FuncionarioRepository repository) 
	{
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception 
	{
		this.repository.save(new Funcionario("Weslei", "Dias", "Teste"));
		this.repository.save(new Funcionario("Felipe", "Silva", "Teste"));	
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Marcio Gomes de Assis");
		pessoa.setTelefone("992334470");
		pessoa.setTipo_pessoa("Jurídica");
		pessoa.setCpfCnpj("07577375608");
		
		this.pessoaRepository.save(pessoa);
		
		ContaBancaria conta = new ContaBancaria();
		conta.setNumeroConta("001");
		conta.setSaldo_atual(200);
		conta.setPessoa(pessoa);
		contaRepository.save(conta);
		
		
		ContaBancaria conta2 = new ContaBancaria();
		conta2.setNumeroConta("002");
		conta2.setSaldo_atual(3000);
		conta2.setPessoa(pessoa);
		contaRepository.save(conta2);
		
		//pessoa.add(conta);
		//pessoa.add(conta2);
		//pessoaRepository.save(pessoa);
		
		
		
		OperacaoFinanceira operacaoFinanceira = new OperacaoFinanceira();
		operacaoFinanceira.setContaBancaria(conta);
		operacaoFinanceira.setTipo_operacao("Depósito");
		operacaoFinanceira.setValor(100);
		operacaoBancariaRepository.save(operacaoFinanceira);
		
		OperacaoFinanceira operacaoFinanceira2 = new OperacaoFinanceira();
		operacaoFinanceira2.setContaBancaria(conta);
		operacaoFinanceira2.setTipo_operacao("Depósito");
		operacaoFinanceira2.setValor(300);
		operacaoBancariaRepository.save(operacaoFinanceira);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}