/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.condominiomodel.Mensalidades;
import br.edu.ifsul.condominiomodel.Aluguel;
import br.edu.ifsul.dao.AluguelDAO;
import br.edu.ifsul.dao.MensalidadesDAO;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darlan
 */
@Named(value = "controleMensalidades")
@ViewScoped
public class ControleMensalidades implements Serializable {
    
    @EJB
    private MensalidadesDAO<Mensalidades> dao;
     
    @EJB
    private AluguelDAO<Aluguel> daoAluguel;
     
    private Mensalidades objeto;

    public ControleMensalidades() {
    }
    
    public String listar(){
        return "/privado/mensalidades/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Mensalidades();
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

    public MensalidadesDAO<Mensalidades> getDao() {
        return dao;
    }

    public void setDao(MensalidadesDAO<Mensalidades> dao) {
        this.dao = dao;
    }

    public Mensalidades getObjeto() {
        return objeto;
    }

    public void setObjeto(Mensalidades objeto) {
        this.objeto = objeto;
    }

    public AluguelDAO<Aluguel> getDaoAluguel() {
        return daoAluguel;
    }

    public void setDaoAluguel(AluguelDAO<Aluguel> daoAluguel) {
        this.daoAluguel = daoAluguel;
    }
    
    
}
