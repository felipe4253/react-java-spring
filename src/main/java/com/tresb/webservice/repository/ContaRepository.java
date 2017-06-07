package com.tresb.webservice.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Pessoa;

@RepositoryRestResource
public interface ContaRepository extends 
PagingAndSortingRepository<ContaBancaria, Long> 
{
	public List<ContaBancaria> findAllByPessoa(Pessoa pessoa);
	
	public ContaBancaria findByNumeroConta(String numeroConta);
	
}
