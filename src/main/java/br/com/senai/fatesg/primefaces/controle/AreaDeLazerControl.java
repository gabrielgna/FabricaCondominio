package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.AreaDeLazer;

import br.com.senai.fatesg.primefaces.persistencia.AreaDeLazerDao;

@Named("AreaDeLazerControl")
@Scope("conversation")
public class AreaDeLazerControl {

	private AreaDeLazer areadelazer = new AreaDeLazer();

	@Autowired
	private AreaDeLazerDao areasdelazerDao;

	private List<AreaDeLazer> areasdelazer = new ArrayList<AreaDeLazer>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void listar(ActionEvent evt) {
		try {
			areasdelazer = areasdelazerDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void confirmar(ActionEvent evt) {
		try {
			areasdelazerDao.alterar(areadelazer);
			listar(evt);
			areadelazer = new AreaDeLazer();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public AreaDeLazer getAreadelazer() {
		return areadelazer;
	}

	public void setAreadelazer(AreaDeLazer areadelazer) {
		this.areadelazer = areadelazer;
	}

	public List<AreaDeLazer> getAreasdelazer() {
		return areasdelazer;
	}

}
