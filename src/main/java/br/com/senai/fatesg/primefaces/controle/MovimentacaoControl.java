package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.senai.fatesg.primefaces.entidade.Cadastrados;
import br.com.senai.fatesg.primefaces.entidade.Movimentacao;
import br.com.senai.fatesg.primefaces.persistencia.CadastradosDao;
import br.com.senai.fatesg.primefaces.persistencia.MovimentacaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.AreaDeLazer;
import br.com.senai.fatesg.primefaces.persistencia.AreaDeLazerDao;
import br.com.senai.fatesg.primefaces.persistencia.AreaDeLazerDaoJpa;

@Named("MovimentacaoControl")
@Scope("conversation")
public class MovimentacaoControl {
    private Movimentacao movimentacao = new Movimentacao();

    @Autowired
    private MovimentacaoDao movimentacaoDao;


    public void Confirmar(Cadastrados cadastrados){
        movimentacao.setCadastrados(cadastrados);
        movimentacao.setHorario(new Date());
        movimentacaoDao.incluir(movimentacao);
        addMessage("Sucesso");
        movimentacao = new Movimentacao();
        //falta implementar tipo
    }


    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
