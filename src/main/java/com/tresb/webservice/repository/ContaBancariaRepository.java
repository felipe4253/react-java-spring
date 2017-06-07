package com.tresb.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.ContaBancaria;


@RepositoryRestResource
public interface ContaBancariaRepository extends PagingAndSortingRepository<ContaBancaria, Long>{
	
	@Query("select c.numero_conta, c.saldo_atual from ContaBancaria c where pessoa_id = :id")
	public List<ContaBancaria> buscarContas(@Param("id") Long id);

	@Query("select c from ContaBancaria c where numero_conta = :numero_conta")
	public ContaBancaria buscarConta(@Param("numero_conta") Integer numero_conta);
	
}
