package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Empresa;
import br.com.senai.fatesg.primefaces.entidade.PessoaImovelTipo;
import br.com.senai.fatesg.primefaces.persistencia.EmpresaDao;
import br.com.senai.fatesg.primefaces.persistencia.PessoalImovelTipoDao;

@Named("PessoaImovelTipoControl")
@Scope("conversation")
public class PessoaImovelTipoControl {

	private PessoaImovelTipo pessoa = new PessoaImovelTipo();

	@Autowired
	private PessoalImovelTipoDao pessoaImovelDao;

	private List<PessoaImovelTipo> ListapessoaImovel = new ArrayList<PessoaImovelTipo>();
	

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void listar(ActionEvent evt) {
		try {
			ListapessoaImovel = pessoaImovelDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public PessoaImovelTipo getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaImovelTipo pessoa) {
		this.pessoa = pessoa;
	}

	public List<PessoaImovelTipo> getListapessoaImovel() {
		return ListapessoaImovel;
	}

	public void incluir(ActionEvent evt) {
		try {
			pessoaImovelDao.incluir(pessoa);
			listar(evt);
			pessoa = new PessoaImovelTipo();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	


	
}



