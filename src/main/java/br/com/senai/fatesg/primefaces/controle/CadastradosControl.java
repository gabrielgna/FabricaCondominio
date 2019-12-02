package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;

import br.com.senai.fatesg.primefaces.entidade.Cadastrados;
import br.com.senai.fatesg.primefaces.persistencia.CadastradosDao;

@Named("CadastradosControl")
@Scope("conversation")
public class CadastradosControl {

	private Cadastrados cadastrado = new Cadastrados();

	@Autowired
	private CadastradosDao cadastradosDao;

	private List<Cadastrados> cadastrados = new ArrayList<Cadastrados>();

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

}
