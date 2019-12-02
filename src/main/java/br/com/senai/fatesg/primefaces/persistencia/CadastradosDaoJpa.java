package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Cadastrados;

@Repository("cadastradosDao")
public class CadastradosDaoJpa extends PersistenciaJpa<Cadastrados> implements CadastradosDao{

   private static final long serialVersionUID = 1L;

}
