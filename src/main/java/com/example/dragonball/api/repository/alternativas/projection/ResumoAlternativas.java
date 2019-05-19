package com.example.dragonball.api.repository.alternativas.projection;

import com.example.dragonball.api.model.TipoSerie;

public class ResumoAlternativas {
	
	private String titulo;
	
	private String link;
	
	private String pergunta;
	
	private String alternativa1;
	
	private String alternativa2;
	
	private String alternativa3;
	
	private String alternativa4;
	
	private TipoSerie tipo;
	
	
	

	public ResumoAlternativas(String titulo, String link, String pergunta, String alternativa1, String alternativa2,
			String alternativa3, String alternativa4, TipoSerie tipo) {
		this.titulo = titulo;
		this.link = link;
		this.pergunta = pergunta;
		this.alternativa1 = alternativa1;
		this.alternativa2 = alternativa2;
		this.alternativa3 = alternativa3;
		this.alternativa4 = alternativa4;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAlternativa1() {
		return alternativa1;
	}

	public void setAlternativa1(String alternativa1) {
		this.alternativa1 = alternativa1;
	}

	public String getAlternativa2() {
		return alternativa2;
	}

	public void setAlternativa2(String alternativa2) {
		this.alternativa2 = alternativa2;
	}

	public String getAlternativa3() {
		return alternativa3;
	}

	public void setAlternativa3(String alternativa3) {
		this.alternativa3 = alternativa3;
	}

	public String getAlternativa4() {
		return alternativa4;
	}

	public void setAlternativa4(String alternativa4) {
		this.alternativa4 = alternativa4;
	}

	public TipoSerie getTipo() {
		return tipo;
	}

	public void setTipo(TipoSerie tipo) {
		this.tipo = tipo;
	}
	
	
}
