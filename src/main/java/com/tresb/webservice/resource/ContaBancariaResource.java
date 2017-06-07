package com.tresb.webservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.repository.ContaBancariaRepository;


@RestController
public class ContaBancariaResource {
	
	@Autowired
	ContaBancariaRepository repository;
	
	@RequestMapping(value="/contabancaria/{idPessoa}", method = RequestMethod.GET)
	public ContaBancaria findByIdPessoa(@PathVariable("idPessoa") long id) {
		return repository.findOne(id);
	}
}
