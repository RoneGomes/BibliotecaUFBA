package br.com.ufba.biblioteca.entidades;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Emprestimo extends Entidade {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id_fk", nullable = false)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "livro_id_fk", nullable = false)
	private Livro livro;

	@Column(name = "data_inicio", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicio;

	@Column(name = "data_fim", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFim;

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
