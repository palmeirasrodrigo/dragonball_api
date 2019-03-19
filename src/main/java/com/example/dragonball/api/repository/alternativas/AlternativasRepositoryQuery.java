package com.example.dragonball.api.repository.alternativas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.repository.alternativas.filter.AlternativasFilter;
import com.example.dragonball.api.repository.alternativas.projection.MostrarSeries;
import com.example.dragonball.api.repository.alternativas.projection.ResumoAlternativas;

public interface AlternativasRepositoryQuery {
	public Page<Alternativas> filtrar(AlternativasFilter alternativasFilter, Pageable pageable);
	public Page<ResumoAlternativas> resumir(AlternativasFilter alternativasFilter, Pageable pageable);
	public Page<MostrarSeries> series(AlternativasFilter alternativasFilter, Pageable pageable);
}
