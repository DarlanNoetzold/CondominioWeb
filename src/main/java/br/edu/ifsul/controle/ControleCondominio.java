/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.condominiomodel.Condominio;
import br.edu.ifsul.condominiomodel.UnidadeCondominal;
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
    private UnidadeCondominal unidadeCondominal;
    private Boolean novoUnidadeCondominal;


    public ControleCondominio() {
    }
    
    public void novoUnidadeCondominal(){
        unidadeCondominal = new UnidadeCondominal();
        novoUnidadeCondominal = true;
    }
    
    public void alterarUnidadeCondominal(int index){
        unidadeCondominal = objeto.getUnidadeCondominal().get(index);
        novoUnidadeCondominal = false;
    }
    
    public void salvarUnidadeCondominal(){
        if (novoUnidadeCondominal){
            objeto.adicionarUnidadeCondominal(unidadeCondominal);
        }
        Util.mensagemInformacao("UnidadeCondominal adicionado ou alterado com sucesso!");
    }
    
    public void removerUnidadeCondominal(int index){
        objeto.removerUnidadeCondominal(index);
        Util.mensagemInformacao("UnidadeCondominal removido com sucesso!");
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

    public Boolean getNovoUnidadeCondominal() {
        return novoUnidadeCondominal;
    }

    public void setNovoUnidadeCondominal(Boolean novoUnidadeCondominal) {
        this.novoUnidadeCondominal = novoUnidadeCondominal;
    }

    public UnidadeCondominal getUnidadeCondominal() {
        return unidadeCondominal;
    }

    public void setUnidadeCondominal(UnidadeCondominal unidadeCondominal) {
        this.unidadeCondominal = unidadeCondominal;
    }
    
}

