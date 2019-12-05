package br.com.senai.fatesg.primefaces.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoCadastrado {

	@Id
	@GeneratedValue(generator = "tipocadastrado_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "tipocadastrado_seq", sequenceName = "tipocadastrado_seq", allocationSize = 1, initialValue = 1)
	private int id;
	
	private String tipo;

	@ManyToMany(mappedBy="listPessoaImovelTipo", cascade=CascadeType.ALL)
	private List<Cadastrados> cadastrados;
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	
}
