package br.com.ufba.biblioteca.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Emprestimo> emprestimos;

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

}
