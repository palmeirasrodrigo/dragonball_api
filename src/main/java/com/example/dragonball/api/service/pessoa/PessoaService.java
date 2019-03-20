package com.example.dragonball.api.service.pessoa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dragonball.api.model.Usuario;

public interface PessoaService {

	List<Usuario> listar();

	Usuario criar(Usuario pessoa);

	Usuario buscarPeloCodigo(Long codigo);

	void remover(Long codigo);

	Usuario atualizar(Long codigo, Usuario pessoa);

	Page<Usuario> pesquisar(String nome, Pageable pageable);

	void validarPessoa(Usuario pessoa);

	void atualizarSenha(long codigo, String senha);

	Usuario atualizarPontos(Long codigo, int pontos);

}
