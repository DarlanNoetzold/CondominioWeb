/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.condominiomodel.Aluguel;
import br.edu.ifsul.condominiomodel.Locatario;
import br.edu.ifsul.condominiomodel.Mensalidades;
import br.edu.ifsul.condominiomodel.UnidadeCondominal;
import br.edu.ifsul.dao.AluguelDAO;
import br.edu.ifsul.dao.LocatarioDAO;
import br.edu.ifsul.dao.UnidadeCondominalDAO;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darla
 */
@Named(value = "controleAluguel")
@ViewScoped
public class ControleAluguel implements Serializable {
    
    @EJB
    private AluguelDAO<Aluguel> dao;
    private Aluguel objeto;
    private int abaAtiva;
    private Mensalidades mensalidades;
    private Boolean novaMensalidade;
    
    @EJB
    private LocatarioDAO<Locatario> daoLocatario;
    
    @EJB
    private UnidadeCondominalDAO<UnidadeCondominal> daoUnidadeCondominal;

    public ControleAluguel() {
    }
    
    public void imprimeAlugeis(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioAluguel", parametros, dao.getListaObjetosCompleta());
    }
    
    public void imprimeAluguel(Object id){
        try {
            objeto = dao.getObjectByID(id);
            List<Aluguel> lista = new ArrayList<>();
            lista.add(objeto);
            HashMap parametros = new HashMap();
            UtilRelatorios.imprimeRelatorio("relatorioAluguel", parametros,lista);            
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao imprimir: " + Util.getMensagemErro(e));
        }
    } 
    
    public void novoMensalidades(){
        mensalidades = new Mensalidades();
        novaMensalidade = true;
    }
    
    public void alterarMensalidades(int index){
        mensalidades = objeto.getMensalidades().get(index);
        novaMensalidade = false;
    }
    
    public void salvarMensalidades(){
        if (novaMensalidade){
            objeto.adicionarMensalidade(mensalidades);
        }
        Util.mensagemInformacao("Mensalidades adicionado ou alterado com sucesso!");
    }
    
    public void removerMensalidades(int index){
        objeto.removerMensalidade(index);
        Util.mensagemInformacao("Mensalidades removido com sucesso!");
    }
    
    public String listar(){
        return "/privado/aluguel/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Aluguel();
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

    public AluguelDAO<Aluguel> getDao() {
        return dao;
    }

    public void setDao(AluguelDAO<Aluguel> dao) {
        this.dao = dao;
    }

    public Aluguel getObjeto() {
        return objeto;
    }

    public void setObjeto(Aluguel objeto) {
        this.objeto = objeto;
    }

    public LocatarioDAO<Locatario> getDaoLocatario() {
        return daoLocatario;
    }

    public void setDaoLocatario(LocatarioDAO<Locatario> daoLocatario) {
        this.daoLocatario = daoLocatario;
    }

    public UnidadeCondominalDAO<UnidadeCondominal> getDaoUnidadeCondominal() {
        return daoUnidadeCondominal;
    }

    public void setDaoUnidadeCondominal(UnidadeCondominalDAO<UnidadeCondominal> daoUnidadeCondominal) {
        this.daoUnidadeCondominal = daoUnidadeCondominal;
    }

    public int getAbaAtiva() {
        return abaAtiva;
    }

    public void setAbaAtiva(int abaAtiva) {
        this.abaAtiva = abaAtiva;
    }

    public Mensalidades getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(Mensalidades mensalidades) {
        this.mensalidades = mensalidades;
    }

    public Boolean getNovaMensalidade() {
        return novaMensalidade;
    }

    public void setNovaMensalidade(Boolean novaMensalidade) {
        this.novaMensalidade = novaMensalidade;
    }
    
    
}
