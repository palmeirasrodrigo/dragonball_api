package com.example.dragonball.api.repository.alternativas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.model.Alternativas_;
import com.example.dragonball.api.repository.alternativas.filter.AlternativasFilter;
import com.example.dragonball.api.repository.alternativas.projection.MostrarSeries;
import com.example.dragonball.api.repository.alternativas.projection.ResumoAlternativas;

public class AlternativasRepositoryImpl implements AlternativasRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Alternativas> filtrar(AlternativasFilter alternativasFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Alternativas> criteria = builder.createQuery(Alternativas.class);
		Root<Alternativas> root = criteria.from(Alternativas.class);
		
		//criar as restrições
		Predicate[] predicates = criarRestricoes(alternativasFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Alternativas> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(alternativasFilter)) ;
		}

	@Override
	public Page<ResumoAlternativas> resumir(AlternativasFilter alternativasFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoAlternativas>criteria = builder.createQuery(ResumoAlternativas.class);
		Root<Alternativas> root = criteria.from(Alternativas.class);
		criteria.select(builder.construct(ResumoAlternativas.class
				,root.get(Alternativas_.titulo), root.get(Alternativas_.link)
				,root.get(Alternativas_.pergunta), root.get(Alternativas_.alternativa1)
				,root.get(Alternativas_.alternativa2),root.get(Alternativas_.alternativa3)
				,root.get(Alternativas_.alternativa4)));
		Predicate[] predicates = criarRestricoes(alternativasFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoAlternativas> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(alternativasFilter)) ;
	}

	@Override
	public Page<MostrarSeries> series(AlternativasFilter alternativasFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<MostrarSeries>criteria = builder.createQuery(MostrarSeries.class);
		Root<Alternativas> root = criteria.from(Alternativas.class);
		criteria.select(builder.construct(MostrarSeries.class
				,root.get(Alternativas_.tipo)));
		Predicate[] predicates = criarRestricoes(alternativasFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<MostrarSeries> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(alternativasFilter)) ;
	}

	
		private Predicate[] criarRestricoes(AlternativasFilter alternativasFilter, CriteriaBuilder builder,
			Root<Alternativas> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(alternativasFilter.getSerie() != null) {
			predicates.add(builder.equal(root.get(Alternativas_.tipo), alternativasFilter.getSerie()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
		}
	
	private Long total(AlternativasFilter alternativasFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Alternativas> root = criteria.from(Alternativas.class);
		
		Predicate[] predicates = criarRestricoes(alternativasFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	
}
