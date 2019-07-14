package br.com.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.entity.LoginEntity;
import br.com.api.utils.GenericRepository;

public class TesteRepostory<TesteEntity>{
	
	@Autowired
	private GenericRepository<LoginEntity, Long> repository;
	
	

}
