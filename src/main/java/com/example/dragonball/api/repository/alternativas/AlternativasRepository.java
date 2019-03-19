package com.example.dragonball.api.repository.alternativas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dragonball.api.model.Alternativas;

public interface AlternativasRepository extends JpaRepository<Alternativas, Long>, AlternativasRepositoryQuery{

}
