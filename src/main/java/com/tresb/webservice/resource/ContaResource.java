package com.tresb.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Funcionario;
import com.tresb.webservice.repository.ContaRepository;

@RestController
public class ContaResource {
	@Autowired
	ContaRepository repository;
	
	@RequestMapping(value="/contas", method = RequestMethod.GET)
	public List<ContaBancaria> listar() {
		return (List<ContaBancaria>) repository.findAll();
	}
	
	@RequestMapping(value="/conta/{id}", method = RequestMethod.GET)
	public ContaBancaria findById(@PathVariable("id") long id) {
		return repository.findOne(id);
	}
	
	
	

}
