package br.com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	
	@Query(value="select u from UserEntity u where u.userName=?")
	UserEntity getUsuario(String userName);
}
