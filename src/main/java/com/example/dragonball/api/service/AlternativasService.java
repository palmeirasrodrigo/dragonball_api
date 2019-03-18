package com.example.dragonball.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.model.Usuario;
import com.example.dragonball.api.repository.AlternativasRepository;
import com.example.dragonball.api.repository.UsuarioRepository;
import com.example.dragonball.api.service.exception.UsuarioInexistente;

@Service
public class AlternativasService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AlternativasRepository alternativasRepository;

	public Alternativas salvar(Alternativas alternativas) {
		Usuario usuario= usuarioRepository.findOne(alternativas.getUsuario().getCodigo());
		if(usuario == null) {
			throw new UsuarioInexistente();
		}
		return alternativasRepository.save(alternativas);
	}

	public void remover(long codigo) {
		alternativasRepository.delete(codigo);
	}
	
}
