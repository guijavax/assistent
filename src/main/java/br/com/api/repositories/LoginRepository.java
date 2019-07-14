package br.com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long>{}
