package br.com.senai.fatesg.primefaces.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Cadastrados {

	@Id
	@GeneratedValue(generator = "cadastrados_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cadastrados_seq", sequenceName = "cadastrados_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String cpf;
	
	@OneToMany
	@JoinColumn(name="movimentacao_id")
	private List<Movimentacao> movimentacoes;
	
	@OneToMany
	@JoinColumn(name="pessoa_id")
	private List<PessoaImovelTipo> pessoaimoveltipo;
	
	private String usuario;
	private String senha;
	private String email;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
}