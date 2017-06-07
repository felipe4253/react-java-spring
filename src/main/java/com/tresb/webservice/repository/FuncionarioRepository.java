package com.tresb.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tresb.webservice.entity.Funcionario;

/**
 * @author weslei.dias
 */
@RepositoryRestResource
public interface FuncionarioRepository extends 
	PagingAndSortingRepository<Funcionario, Long> 
{

}
