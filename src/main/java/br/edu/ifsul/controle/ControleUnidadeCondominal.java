/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.condominiomodel.UnidadeCondominal;
import br.edu.ifsul.dao.UnidadeCondominalDAO;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darla
 */
@Named(value = "controleUnidadeCondominal")
@ViewScoped
public class ControleUnidadeCondominal implements Serializable {
    
    @EJB
    private UnidadeCondominalDAO<ControleUnidadeCondominal> dao;
    private UnidadeCondominal objeto;

    public ControleUnidadeCondominal() {
    }
    
    public String listar(){
        return "/privado/unidadeCondominal/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new UnidadeCondominal();
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
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

    public UnidadeCondominalDAO<ControleUnidadeCondominal> getDao() {
        return dao;
    }

    public void setDao(UnidadeCondominalDAO<ControleUnidadeCondominal> dao) {
        this.dao = dao;
    }

    public UnidadeCondominal getObjeto() {
        return objeto;
    }

    public void setObjeto(UnidadeCondominal objeto) {
        this.objeto = objeto;
    }

   
    
    
}
