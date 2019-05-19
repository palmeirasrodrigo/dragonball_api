package com.example.dragonball.api.repository.alternativas.filter;

import com.example.dragonball.api.model.TipoSerie;

public class AlternativasFilter {
	
	private TipoSerie serie;
	private int episodio;
	private int esfera;


	

	public int getEpisodio() {
		return episodio;
	}

	public void setEpisodio(int episodio) {
		this.episodio = episodio;
	}

	public TipoSerie getSerie() {
		return serie;
	}

	public void setSerie(TipoSerie serie) {
		this.serie = serie;
	}

	public int getEsfera() {
		return esfera;
	}

	public void setEsfera(int esfera) {
		this.esfera = esfera;
	}
	
	
	
		
}
