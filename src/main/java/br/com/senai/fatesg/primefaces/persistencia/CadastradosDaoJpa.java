package br.com.senai.fatesg.primefaces.persistencia;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.annotation.Query;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.controle.CadastradosControl;
import br.com.senai.fatesg.primefaces.entidade.Cadastrados;

@Repository("cadastradosDao")
public class CadastradosDaoJpa extends PersistenciaJpa<Cadastrados> implements CadastradosDao {

	private static final long serialVersionUID = 1L;

}
