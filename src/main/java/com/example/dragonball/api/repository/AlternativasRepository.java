package com.example.dragonball.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dragonball.api.model.Alternativas;
import com.example.dragonball.api.repository.alternativas.AlternativasRepositoryQuery;

public interface AlternativasRepository extends JpaRepository<Alternativas, Long>, AlternativasRepositoryQuery{

}
