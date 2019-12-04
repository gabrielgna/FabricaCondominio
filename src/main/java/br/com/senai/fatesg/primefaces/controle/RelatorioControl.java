package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.senai.fatesg.primefaces.entidade.Cadastrados;

@Named("RelatorioControl")
@Scope("conversation")
public class RelatorioControl {

	private Cadastrados cadastradoSelecioando;
	
	private List<Cadastrados> cadastrados = new ArrayList<Cadastrados>();
	
	
	public List<Cadastrados> getCadastrados() {
		return cadastrados;
	}
}
