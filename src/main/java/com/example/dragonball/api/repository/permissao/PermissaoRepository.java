package com.example.dragonball.api.repository.permissao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dragonball.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>, PermissaoRepositoryQuery {
	
}

