package com.example.dragonball.api.service.pessoa;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dragonball.api.model.Usuario;
import com.example.dragonball.api.repository.usuario.UsuarioRepository;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private UsuarioRepository pessoaRepository;
		
	@Override
	public List<Usuario> listar() {		
		return pessoaRepository.findAll();
	}

	@Override
	public Usuario criar(Usuario pessoa) {		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Usuario buscarPeloCodigo(Long codigo) {		
		return pessoaRepository.findOne(codigo);
	}

	@Override
	public void remover(Long codigo) {
		pessoaRepository.delete(codigo);		
	}

	@Override
	public Page<Usuario> pesquisar(String nome, Pageable pageable) {		
		return pessoaRepository.findByNomeContaining(nome, pageable);
	}

	public Usuario atualizar(Long codigo, Usuario pessoa) {
		Usuario pessoaSalva = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	

	public Usuario buscarPessoaPeloCodigo(Long codigo) {
		Usuario pessoaSalva = pessoaRepository.findOne(codigo);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	public void validarPessoa(Usuario pessoa) {
		if (pessoa != null) {
			pessoa = pessoaRepository.findOne(pessoa.getCodigo());
		}

		}

	@Override
	public void atualizarSenha(long codigo, String senha) {
		Usuario usuario = buscarPessoaPeloCodigo(codigo);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		}

	@Override
	public Usuario atualizarPontos(Long codigo, int pontos) {
		Usuario usuario = buscarPessoaPeloCodigo(codigo);
		int total = usuario.getPontos() + pontos;
		usuario.setPontos(total);
		return pessoaRepository.save(usuario);
	}
	
}
