package com.example.dragonball.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dragonball.api.event.RecursoCriadoEvent;
import com.example.dragonball.api.model.Usuario;
import com.example.dragonball.api.repository.usuario.UsuarioRepository;
import com.example.dragonball.api.service.pessoa.PessoaService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PessoaService usuarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	//@PreAuthorize("hasAuthority('ROLE_LISTAR_USUARIOS')")
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		usuario.setPontos(0);
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		usuarioService.atualizarSenha(usuarioSalvo.getCodigo(), usuarioSalvo.getSenha());
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}  
	//@PreAuthorize("hasAuthority('ROLE_LISTAR_USUARIOS')")
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long codigo) {
		 Usuario findOne = usuarioRepository.findOne(codigo);
		 return findOne != null ? ResponseEntity.ok(findOne): ResponseEntity.notFound().build();
				 
	}
	
	//@PreAuthorize("hasAuthority('ROLE_DELETAR_USUARIOS')")
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		usuarioRepository.delete(codigo);
	}
	
	//@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_USUARIOS')")
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long codigo, @Valid @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioService.atualizar(codigo, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping("/{codigo}/pontos")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Usuario> atualizarPontos(@PathVariable Long codigo, @RequestBody int pontos) {
		Usuario usuarioSalvo = usuarioService.atualizarPontos(codigo, pontos);
		return ResponseEntity.ok(usuarioSalvo);
	}
}
