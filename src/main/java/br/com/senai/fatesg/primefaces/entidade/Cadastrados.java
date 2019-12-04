package br.com.senai.fatesg.primefaces.entidade;

import java.util.ArrayList;
import java.util.Date;
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
	@JoinColumn(name = "pessoa_id")
	private List<PessoaImovelTipo> pessoaimoveltipo;

	private String email;
	private String nome;
	private String celular;
	private Date datadenascimento;
	private int statuscadastro;

	

	public List<PessoaImovelTipo> getPessoaimoveltipo() {
		return pessoaimoveltipo;
	}

	public void setPessoaimoveltipo(List<PessoaImovelTipo> pessoaimoveltipo) {
		this.pessoaimoveltipo = pessoaimoveltipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDatadenascimento() {
		return datadenascimento;
	}

	public void setDatadenascimento(Date datadenascimento) {
		this.datadenascimento = datadenascimento;
	}

	public int getStatuscadastro() {
		return statuscadastro;
	}

	public void setStatuscadastro(int statuscadastro) {
		this.statuscadastro = statuscadastro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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