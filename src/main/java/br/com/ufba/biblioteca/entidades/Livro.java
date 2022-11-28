package br.com.ufba.biblioteca.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Livro extends Entidade {

	@Column(nullable = false, length = 40)
	private String nome;

	@Column(nullable = false, length = 40)
	private String autor;

	@Column(nullable = false, length = 40)
	private String editora;

	@Column(nullable = false, length = 40)
	private String materia;

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
