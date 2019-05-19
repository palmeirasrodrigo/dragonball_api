package com.example.dragonball.api.repository.alternativas;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.repository.alternativas.filter.AlternativasFilter;
import com.example.dragonball.api.repository.alternativas.projection.MostrarSeries;
import com.example.dragonball.api.repository.alternativas.projection.ResumoAlternativas;

public interface AlternativasRepositoryQuery {
	public List<Alternativas> filtrar(AlternativasFilter alternativasFilter);
	public Page<ResumoAlternativas> resumir(AlternativasFilter alternativasFilter, Pageable pageable);
	public Page<MostrarSeries> series(AlternativasFilter alternativasFilter, Pageable pageable);
	public List<Alternativas> buscar(Alternativas alternativasFilter);
}
