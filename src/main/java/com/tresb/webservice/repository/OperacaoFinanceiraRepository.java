package com.tresb.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.OperacaoFinanceira;


@RepositoryRestResource
public interface OperacaoFinanceiraRepository extends PagingAndSortingRepository<OperacaoFinanceira, Long>{
	
	

}
