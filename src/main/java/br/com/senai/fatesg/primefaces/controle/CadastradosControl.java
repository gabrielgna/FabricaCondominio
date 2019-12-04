package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import javax.inject.Named;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

import br.com.senai.fatesg.primefaces.entidade.Cadastrados;
import br.com.senai.fatesg.primefaces.entidade.PessoaImovelTipo;
import br.com.senai.fatesg.primefaces.persistencia.CadastradosDao;
import br.com.senai.fatesg.primefaces.persistencia.PessoalImovelTipoDao;

@Named("CadastradosControl")
@Scope("conversation")
public class CadastradosControl {
//entidades
	private Cadastrados cadastrado = new Cadastrados();

	private PessoaImovelTipo pessoatipo = new PessoaImovelTipo();
	//daos
	@Autowired
	private CadastradosDao cadastradosDao;
	
	@Autowired
	private PessoalImovelTipoDao pessoaimovetipodao;

	//listas
	private List<Cadastrados> cadastrados = new ArrayList<Cadastrados>();

	private List<PessoaImovelTipo> listatipo = new ArrayList<PessoaImovelTipo>();
	
	@PostConstruct
	public void init() {
		listar(null);
	}

	
	public void listar(ActionEvent evt) {
		try {
			cadastrados = cadastradosDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	

	public void confirmar(ActionEvent evt) {
		try {
			cadastradosDao.incluir(cadastrado);
			
			listar(evt);
			cadastrado = new Cadastrados();
			pessoatipo = new PessoaImovelTipo();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listarr(ActionEvent evt) {
		try {
			Query query = cadastradosDao.getEntityManager().createQuery("SELECT * FROM cadastrados where id=2");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Cadastrados getCadastrado() {
		return cadastrado;
	}

	public void setCadastrado(Cadastrados cadastrado) {
		this.cadastrado = cadastrado;
	}

	public List<Cadastrados> getCadastrados() {
		return cadastrados;
	}

}
