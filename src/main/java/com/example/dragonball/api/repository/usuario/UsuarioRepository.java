package com.example.dragonball.api.repository.usuario;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dragonball.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {
	
	public Optional<Usuario> findByEmail(String email);

	public Page<Usuario> findByNomeContaining(String nome, Pageable pageable);

}
