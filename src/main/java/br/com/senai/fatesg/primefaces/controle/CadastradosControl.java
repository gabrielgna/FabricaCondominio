package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


import org.hibernate.EntityMode;
import org.hibernate.Session;

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
	
	private String nome;
	

	private List<TipoCadastrado> listPessoaImovelTipo = new ArrayList<TipoCadastrado>();
	
	@PostConstruct
	public void init() {
		listar(null);
	}

	public void listar(ActionEvent evt) {
		try {
			cadastrados = cadastradosDao.listar();
			listPessoaImovelTipo = tipoCadastradoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	
	}

	public void PesquisarNome() {
	  cadastrados=cadastradosDao.buscaPor(this.nome);
	  System.out.println();
	}
	
	
	public void confirmar() {

		try {
			cadastrado.addTipoCadastro(tipocadastrado);
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

	public List<Cadastrados> getCadastrados() {
		return cadastrados;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCadastrado getTipocadastrado() {
		return tipocadastrado;
	}

	public void setTipocadastrado(TipoCadastrado tipocadastrado) {
		this.tipocadastrado = tipocadastrado;
	}

	public List<TipoCadastrado> getTiposCadastrados() {
		return listPessoaImovelTipo;
	}

	public void setTiposCadastrados(List<TipoCadastrado> tiposCadastrados) {
		this.listPessoaImovelTipo = tiposCadastrados;
	}

}
