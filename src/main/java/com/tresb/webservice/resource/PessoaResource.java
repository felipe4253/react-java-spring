package com.tresb.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Pessoa;
import com.tresb.webservice.repository.ContaBancariaRepository;
import com.tresb.webservice.repository.PessoaRepository;

@RestController
public class PessoaResource {
	
	@Autowired
	PessoaRepository repository;
	
	@Autowired
	ContaBancariaRepository contaBancariaRepository;
	
	@RequestMapping(value="/pessoas", method = RequestMethod.GET)
	public List<Pessoa> listar() {
		return (List<Pessoa>) repository.findAll();
	}
	
	@RequestMapping(value="/pessoa/{id}", method = RequestMethod.GET)
	public Pessoa findById(@PathVariable("id") long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value="/pessoaCPF/{cpf_cnpj}", method = RequestMethod.GET)
	public List<ContaBancaria> findByCpfCnpj(@PathVariable("cpf_cnpj") String cpf_cnpj) {		
		return contaBancariaRepository.buscarContas(repository.buscarPessoa(cpf_cnpj).getId());
	}
	
}
