package com.example.dragonball.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dragonball.api.event.RecursoCriadoEvent;
import com.example.dragonball.api.exceptionhandler.DragonExceptionHandler.Erro;
import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.repository.AlternativasRepository;
import com.example.dragonball.api.repository.filter.AlternativasFilter;
import com.example.dragonball.api.repository.projection.MostrarSeries;
import com.example.dragonball.api.repository.projection.ResumoAlternativas;
import com.example.dragonball.api.service.AlternativasService;
import com.example.dragonball.api.service.exception.UsuarioInexistente;

@RestController
@RequestMapping("/alternativas")
public class AlternativasResource {
	
	@Autowired
	private AlternativasRepository alternativasRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AlternativasService alternativasService;
	
	@GetMapping
	public Page<Alternativas> pesquisar(AlternativasFilter alternativasFilter, Pageable pageable) {
		return alternativasRepository.filtrar(alternativasFilter, pageable);
	}
	
	@GetMapping(params="resumo")
	public Page<ResumoAlternativas> resumir(AlternativasFilter alternativasFilter, Pageable pageable) {
		return alternativasRepository.resumir(alternativasFilter, pageable);
	}
	

	@GetMapping(params="series")
	public Page<MostrarSeries> series(AlternativasFilter alternativasFilter, Pageable pageable) {
		return alternativasRepository.series(alternativasFilter, pageable);
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ALTERNATIVAS')")
	public ResponseEntity<Alternativas> criar(@Valid @RequestBody Alternativas alternativas, HttpServletResponse response) {
		Alternativas alternativasSalva = alternativasService.salvar(alternativas);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, alternativasSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alternativasSalva);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Alternativas> buscarPeloCodigo(@PathVariable Long codigo) {
		 Alternativas findOne = alternativasRepository.findOne(codigo);
		 return findOne != null ? ResponseEntity.ok(findOne): ResponseEntity.notFound().build();
				 
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ALTERNATIVAS')")
	public void remover(@PathVariable long codigo) {
		alternativasService.remover(codigo);
	}
	
	@ExceptionHandler({UsuarioInexistente.class})
	public ResponseEntity<Object>handleUsuarioInexistente(UsuarioInexistente ex) {
		String mensagemUsuario = messageSource.getMessage("pessoa.inexistente", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
}
