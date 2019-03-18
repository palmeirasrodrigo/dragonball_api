package com.example.dragonball.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dragonball.api.model.Usuario;
import com.example.dragonball.api.repository.UsuarioRepository;

@Service
public class PessoaService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalvo = buscarUsuarioPeloCodigo(codigo);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");
		return usuarioRepository.save(usuarioSalvo);
	}
	
	public void atualizarSenha(Long codigo, String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		encoder.encode(senha);
		buscarUsuarioPeloCodigo(codigo).setSenha(encoder.encode(senha));
		usuarioRepository.save(buscarUsuarioPeloCodigo(codigo));
	}


	public void atualizarPontos(Long codigo, int pontos) {
		int pontosAtual = buscarUsuarioPeloCodigo(codigo).getPontos();
		buscarUsuarioPeloCodigo(codigo).setPontos(pontos + pontosAtual);
		usuarioRepository.save(buscarUsuarioPeloCodigo(codigo));
	}

	public Usuario buscarUsuarioPeloCodigo(Long codigo) {
		Usuario usuarioSalvo = usuarioRepository.findOne(codigo);
		if(usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioSalvo;
	}
}
