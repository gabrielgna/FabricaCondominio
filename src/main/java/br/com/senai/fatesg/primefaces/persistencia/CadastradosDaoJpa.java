package br.com.senai.fatesg.primefaces.persistencia;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Cadastrados;

@Repository("cadastradosDao")
public class CadastradosDaoJpa extends PersistenciaJpa<Cadastrados> implements CadastradosDao {

	private static final long serialVersionUID = 1L;

	public List<Cadastrados> buscaPor(String nome) throws PersistenceException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct c from Cadastrados c ");
			sql.append("where  upper(c.nome)  like upper(:nome) ");

			TypedQuery<Cadastrados> query = em.createQuery(sql.toString(), Cadastrados.class);

			query.setParameter("nome", "%" + nome + "%");
			return query.getResultList();
		} catch (Exception e) {
			throw new PersistenciaException("Erro ao consultar assuntos.", e);
		}
	}

	
}
