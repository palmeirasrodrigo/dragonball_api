package com.example.dragonball.api.service.alternativas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.repository.alternativas.filter.AlternativasFilter;
import com.example.dragonball.api.repository.alternativas.projection.ResumoAlternativas;

@Service
public interface AlternativasService {
	
	Alternativas criar(Alternativas lancamento);

	Alternativas atualizar(Long codigo, Alternativas lancamento);

	Page<Alternativas> listar(AlternativasFilter lancamentoFilter, Pageable pageable);

	Page<ResumoAlternativas> resumo(AlternativasFilter lancamentoFilter, Pageable pageable);

	Alternativas buscarPeloCodigo(long codigo);

	void remover(long codigo);
	
}
