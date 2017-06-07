package com.tresb.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresb.webservice.entity.Funcionario;
import com.tresb.webservice.repository.FuncionarioRepository;

@RestController
public class FuncionarioResource {
	
	@Autowired
	FuncionarioRepository repository;
	
	@RequestMapping(value="/funcionarios", method = RequestMethod.GET)
	public List<Funcionario> listar() {
		return (List<Funcionario>) repository.findAll();
	}
	
	@RequestMapping(value="/funcionario/{id}", method = RequestMethod.GET)
	public Funcionario findById(@PathVariable("id") long id) {
		return repository.findOne(id);
	}

}
