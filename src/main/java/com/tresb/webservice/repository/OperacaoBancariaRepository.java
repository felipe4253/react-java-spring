package com.tresb.webservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.OperacaoFinanceira;
@RepositoryRestResource
public interface OperacaoBancariaRepository extends 
PagingAndSortingRepository<OperacaoFinanceira, Long> 
{
	


	
	
}
