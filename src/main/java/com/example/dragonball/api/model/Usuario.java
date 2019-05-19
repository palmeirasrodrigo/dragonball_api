package com.example.dragonball.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	
	@NotNull
	@Size(min=3, max = 50)
	private String nome;
	
	@NotNull
	@Size(min=3, max = 50)
	private String email;
	
	@NotNull
	private String senha;
	
	
	private int pontos;

	//@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name="usuario_permissao", joinColumns = @JoinColumn(name="codigo_usuario"),
	//inverseJoinColumns = @JoinColumn(name="codigo_permissao"))
	
	//private List<Permissao> permissoes;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	//public List<Permissao> getPermissoes() {
		//return permissoes;
	//}

	//public void setPermissoes(List<Permissao> permissoes) {
		//this.permissoes = permissoes;
	//}

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
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	
	
}
