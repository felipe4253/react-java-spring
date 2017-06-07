package com.tresb.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.OperacaoFinanceira;
import com.tresb.webservice.entity.Pessoa;

@RepositoryRestResource
public interface OperacaoFinanceiraRepository extends PagingAndSortingRepository<OperacaoFinanceira, Long>{

}
