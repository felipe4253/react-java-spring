package com.tresb.webservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Pessoa;

/**
 * @author weslei.dias
 */
@Component
public class DatabaseLoader implements CommandLineRunner 
{
	private final PessoaRepository pessoaRepository;
	private final ContaBancariaRepository contaBancariaRepository;

	@Autowired
	public DatabaseLoader(PessoaRepository pessoaRepository, 
						  ContaBancariaRepository contaBancariaRepository){
		this.pessoaRepository = pessoaRepository;
		this.contaBancariaRepository = contaBancariaRepository;
	}

	@Override
	public void run(String... strings) throws Exception{			
		Pessoa pessoa = new Pessoa("Wilson Neto", "06084101607", "Física", "(33)99978-0441");
		this.pessoaRepository.save(pessoa);
		
		ContaBancaria contaBancaria = new ContaBancaria(123123, 123.55, pessoa);		
		this.contaBancariaRepository.save(contaBancaria);	
		contaBancaria = new ContaBancaria(123127, -100.00, pessoa);
		this.contaBancariaRepository.save(contaBancaria);
	}
}