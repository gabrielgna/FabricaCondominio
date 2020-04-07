package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Cadastrados;
import br.com.senai.fatesg.primefaces.entidade.TipoCadastrado;
import br.com.senai.fatesg.primefaces.persistencia.CadastradosDao;
import br.com.senai.fatesg.primefaces.persistencia.TipoCadastradosDao;

@Named("CadastradosControl")
@RequestScoped
public class CadastradosControl {
	// entidades
	private Cadastrados cadastrado = new Cadastrados();

	private TipoCadastrado tipocadastrado = new TipoCadastrado();

	@Autowired
	private CadastradosDao cadastradosDao;

	@Autowired
	private TipoCadastradosDao tipoCadastradoDao;

	// listas
	private List<Cadastrados> cadastrados = new ArrayList<Cadastrados>();
	private List<TipoCadastrado> listaTipoCadastrados = new ArrayList<TipoCadastrado>();
	private String nome;


	@PostConstruct
	public void init() {
		listar(null);
	}


	public void listar(ActionEvent evt) {
		try {
			cadastrados = cadastradosDao.listar();
			listaTipoCadastrados = tipoCadastradoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}

	}

	public void PesquisarNome() {
		cadastrados = cadastradosDao.buscaPor(this.nome);
		System.out.println();
	}


	public void confirmar() {

		try {
			//cadastrado.addTipoCadastro(tipocadastrado);
			cadastradosDao.incluir(cadastrado);
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

	public TipoCadastrado getTipocadastrado() {
		return tipocadastrado;
	}

	public void setTipocadastrado(TipoCadastrado tipocadastrado) {
		this.tipocadastrado = tipocadastrado;
	}

	public CadastradosDao getCadastradosDao() {
		return cadastradosDao;
	}

	public void setCadastradosDao(CadastradosDao cadastradosDao) {
		this.cadastradosDao = cadastradosDao;
	}

	public TipoCadastradosDao getTipoCadastradoDao() {
		return tipoCadastradoDao;
	}

	public void setTipoCadastradoDao(TipoCadastradosDao tipoCadastradoDao) {
		this.tipoCadastradoDao = tipoCadastradoDao;
	}

	public List<Cadastrados> getCadastrados() {
		return cadastrados;
	}

	public void setCadastrados(List<Cadastrados> cadastrados) {
		this.cadastrados = cadastrados;
	}

	public List<TipoCadastrado> getListaTipoCadastrados() {
		return listaTipoCadastrados;
	}

	public void setListaTipoCadastrados(List<TipoCadastrado> listaTipoCadastrados) {
		this.listaTipoCadastrados = listaTipoCadastrados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}