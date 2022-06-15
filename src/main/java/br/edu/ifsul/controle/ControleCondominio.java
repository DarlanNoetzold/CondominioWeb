/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.condominiomodel.Condominio;
import br.edu.ifsul.condominiomodel.Recurso;
import br.edu.ifsul.dao.CondominioDAO;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darla
 */
@Named(value = "controleCondominio")
@ViewScoped
public class ControleCondominio implements Serializable {
    
    @EJB
    private CondominioDAO<Condominio> dao;
    private Condominio objeto;
    private int abaAtiva;
    private Recurso recurso;
    private Boolean novoRecurso;


    public ControleCondominio() {
    }
    
    public void novoRecurso(){
        recurso = new Recurso();
        novoRecurso = true;
    }
    
    public void alterarRecurso(int index){
        recurso = objeto.getRecursos().get(index);
        novoRecurso = false;
    }
    
    public void salvarRecurso(){
        if (novoRecurso){
            objeto.adicionarRecurso(recurso);
        }
        Util.mensagemInformacao("Recurso adicionado ou alterado com sucesso!");
    }
    
    public void removerRecurso(int index){
        objeto.removerRecurso(index);
        Util.mensagemInformacao("Recurso removido com sucesso!");
    }
    
    public String listar(){
        return "/privado/condominio/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Condominio();
        abaAtiva = 0;
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
            abaAtiva = 0;
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
     
    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public CondominioDAO<Condominio> getDao() {
        return dao;
    }

    public void setDao(CondominioDAO<Condominio> dao) {
        this.dao = dao;
    }

    public Condominio getObjeto() {
        return objeto;
    }

    public void setObjeto(Condominio objeto) {
        this.objeto = objeto;
    }
    
    public int getAbaAtiva() {
        return abaAtiva;
    }

    public void setAbaAtiva(int abaAtiva) {
        this.abaAtiva = abaAtiva;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Boolean getNovoRecurso() {
        return novoRecurso;
    }

    public void setNovoRecurso(Boolean novoRecurso) {
        this.novoRecurso = novoRecurso;
    }
    
    
}

