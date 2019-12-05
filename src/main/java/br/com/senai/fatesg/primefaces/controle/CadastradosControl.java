package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import javax.inject.Named;

import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Cadastrados;
import br.com.senai.fatesg.primefaces.persistencia.CadastradosDao;
import br.com.senai.fatesg.primefaces.persistencia.CadastradosDaoJpa;

@Named("CadastradosControl")
@Scope("conversation")
public class CadastradosControl{

	
	private Cadastrados cadastrado = new Cadastrados();
	
	@Autowired
	private CadastradosDao cadastradosDao;

	private List<Cadastrados> cadastrados = new ArrayList<Cadastrados>();
	
	private String nome;
	

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

	public void PesquisarNome() {
	  cadastrados=cadastradosDao.buscaPor(this.nome);
	  System.out.println();
	}
	
	
	public void confirmar(ActionEvent evt) {
		try {
			cadastradosDao.alterar(cadastrado);
			listar(evt);
			cadastrado = new Cadastrados();
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	

}

