package com.example.dragonball.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alternativas")
public class Alternativas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	
	@NotNull
	@Size(min=3, max = 50)
	private String titulo;
	
	@NotNull
	@Size(min=3, max = 50)
	private String link;
	
	@NotNull
	@Size(min=3, max = 50)
	private String pergunta;
	
	@NotNull
	@Size(min=3, max = 50)
	private String alternativa1;
	
	@NotNull
	@Size(min=3, max = 50)
	private String alternativa2;
	
	@NotNull
	@Size(min=3, max = 50)
	private String alternativa3;
	
	@NotNull
	@Size(min=3, max = 50)
	private String alternativa4;
	
	@NotNull
	@Size(min=3, max = 50)
	private String resposta;
	
	@NotNull
  	private int pontos;
	 
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoSerie tipo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario usuario;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
		
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
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
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alternativas other = (Alternativas) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
}
