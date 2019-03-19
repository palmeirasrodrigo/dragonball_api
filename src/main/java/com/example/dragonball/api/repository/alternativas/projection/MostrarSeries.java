package com.example.dragonball.api.repository.alternativas.projection;

import com.example.dragonball.api.model.TipoSerie;

public class MostrarSeries {
	
	private TipoSerie serie;

	public MostrarSeries(TipoSerie serie) {
		this.serie = serie;
	}

	public TipoSerie getSerie() {
		return serie;
	}

	public void setSerie(TipoSerie serie) {
		this.serie = serie;
	}
	
	
}
