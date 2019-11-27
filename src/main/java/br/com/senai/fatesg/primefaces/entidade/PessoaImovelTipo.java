package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PessoaImovelTipo {

	@Id
	@GeneratedValue(generator = "pessoaimoveltipo_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "pessoaimoveltipo_seq", sequenceName = "pessoaimoveltipo_seq", allocationSize = 1, initialValue = 1)
	private int id;
	
	private int tipo;
}
