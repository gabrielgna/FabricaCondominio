package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.PessoaImovelTipo;

@Repository("PessoaImovelTipoDao")
public class PessoaImovelTipoDaoJpa extends PersistenciaJpa<PessoaImovelTipo> implements PessoalImovelTipoDao{

   private static final long serialVersionUID = 1L;

}
