package com.tresb.webservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.ContaBancaria;
import com.tresb.webservice.entity.Pessoa;

@RepositoryRestResource
public interface ContaBancariaRepository extends PagingAndSortingRepository<ContaBancaria, Long>{
	
	@Query("SELECT c FROM ContaBancaria c WHERE c.pessoa = :idPessoa")
	public ContaBancaria findIdPessoa(@Param("idPessoa") Pessoa idPessoa);
	
}
