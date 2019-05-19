package com.example.dragonball.api.service.alternativas;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.dragonball.api.exception.PessoaInexistenteOuInativaException;
import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.model.Usuario;
import com.example.dragonball.api.repository.alternativas.AlternativasRepository;
import com.example.dragonball.api.repository.alternativas.filter.AlternativasFilter;
import com.example.dragonball.api.repository.alternativas.projection.MostrarSeries;
import com.example.dragonball.api.repository.alternativas.projection.ResumoAlternativas;
import com.example.dragonball.api.service.pessoa.PessoaService;

@Service("lancamentoService")
public class AlternativasServiceImpl implements AlternativasService {
	@Autowired
	private AlternativasRepository lancamentoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Override
	public Alternativas criar(Alternativas lancamento) {		
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public Page<Alternativas> listar(AlternativasFilter lancamentoFilter, Pageable pageable) {		
		return lancamentoRepository.findAll(pageable);
	}

	@Override
	public Page<ResumoAlternativas> resumo(AlternativasFilter lancamentoFilter, Pageable pageable) {		
		return lancamentoRepository.resumir(lancamentoFilter, pageable);
	}

	@Override
	public Page<MostrarSeries> serie(AlternativasFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.series(lancamentoFilter, pageable);
	}	

	@Override
	public Alternativas buscarPeloCodigo(long codigo) {		
		return lancamentoRepository.findOne(codigo);
	}

	@Override
	public void remover(long codigo) {
		lancamentoRepository.delete(codigo);		
	}

	public Alternativas salvar(Alternativas lancamento) {
		//Usuario pessoa = pessoaService.buscarPeloCodigo(lancamento.getUsuario().getCodigo());
		//if (pessoa == null) {
			//throw new PessoaInexistenteOuInativaException();
		//}

		return lancamentoRepository.save(lancamento);
	}
	
	public Alternativas atualizar(Long codigo, Alternativas lancamento) {
		Alternativas lancamentoSalvo = buscarLancamentoExistente(codigo);
		//if(!lancamento.getUsuario().equals(lancamento.getUsuario())) {
			//pessoaService.validarPessoa(lancamento.getUsuario());
		//}
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		
		return lancamentoRepository.save(lancamentoSalvo);
	}

	private Alternativas buscarLancamentoExistente(Long codigo) {
		Alternativas lancamentoSalvo = lancamentoRepository.findOne(codigo);
		if (lancamentoSalvo == null) {
			throw new IllegalArgumentException();
		}
		return lancamentoSalvo;
	}

	
}
