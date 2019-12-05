package br.com.senai.fatesg.primefaces.persistencia;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.senai.fatesg.primefaces.entidade.Cadastrados;

public interface CadastradosDao extends Persistencia<Cadastrados> {

	public List<Cadastrados> buscaPor(String nome)throws PersistenceException;
}
