package com.example.dragonball.api.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.dragonball.api.model.Usuario;

public class GeradorSenha {

	public void senhaEncodada(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		encoder.encode(usuario.getSenha());
	}
}
