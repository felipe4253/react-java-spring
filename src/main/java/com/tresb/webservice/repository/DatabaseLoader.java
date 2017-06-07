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
	private final PessoaRepository pessoaRepository;
	private final ContaBancariaRepository contaBancariaRepositry;
	private final OperacaoFinanceiraRepository operacaoRepositry;

	@Autowired
	public DatabaseLoader(FuncionarioRepository repository, PessoaRepository pessoaRepository, ContaBancariaRepository contaBancariaRepositry, OperacaoFinanceiraRepository operacaoRepositry) 
	{
		this.repository = repository;
		this.pessoaRepository = pessoaRepository;
		this.contaBancariaRepositry = contaBancariaRepositry;
		this.operacaoRepositry = operacaoRepositry;
	}

	@Override
	public void run(String... strings) throws Exception 
	{
		this.repository.save(new Funcionario("Weslei", "Dias", "Teste"));
		this.repository.save(new Funcionario("Felipe", "Silva", "Teste"));
		
		Pessoa p1 = new Pessoa();
		p1.setNome("José Martins");
		p1.setCpf_cnpj("12345678909");
		p1.setTipo_pessoa("Fisica");
		p1.setTelefone("(31)99238-4855");
		p1 = this.pessoaRepository.save(p1);
		
		ContaBancaria cb1 = new ContaBancaria();
		cb1.setNumero_conta("123123");
		cb1.setSaldo_atual(123.55);
		cb1.setPessoa(p1);
		cb1 = this.contaBancariaRepositry.save(cb1);
		
		OperacaoFinanceira of1 = new OperacaoFinanceira();
		of1.setTipo_operacao("Credito");
		of1.setValor(50.00);
		of1.setConta_bancaria(cb1);
		//of1.setConta_bancaria_id(cb1.getId());
		this.operacaoRepositry.save(of1);
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Cabuloso de Rico");
		p2.setCpf_cnpj("09876543210");
		p2.setTipo_pessoa("Fisica");
		p2.setTelefone("(33)3333-3333");
		p2 = this.pessoaRepository.save(p2);
		
		ContaBancaria cb2 = new ContaBancaria();
		cb2.setNumero_conta("321123");
		cb2.setSaldo_atual(-100.00);
		cb2.setPessoa(p2);
		//cb2.setPessoa_id(p2.getId());
		cb2 = this.contaBancariaRepositry.save(cb2);
		
		OperacaoFinanceira of2 = new OperacaoFinanceira();
		of2.setTipo_operacao("Debito");
		of2.setValor(500.00);
		of2.setConta_bancaria(cb2);
		//of2.setConta_bancaria_id(cb2.getId());
		this.operacaoRepositry.save(of2);
	}
	
}