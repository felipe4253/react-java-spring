package com.tresb.webservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tresb.webservice.entity.Funcionario;

/**
 * @author weslei.dias
 */
@Component
public class DatabaseLoader implements CommandLineRunner 
{
	private final FuncionarioRepository repository;

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
	}
}