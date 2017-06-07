package com.tresb.webservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tresb.webservice.entity.Pessoa;

@RepositoryRestResource
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>{

	@Query("SELECT p FROM Pessoa p WHERE p.cpf_cnpj = :cpf_cnpj")
	public Pessoa findByCpf(@Param("cpf_cnpj") String cpf_cnpj);

}
