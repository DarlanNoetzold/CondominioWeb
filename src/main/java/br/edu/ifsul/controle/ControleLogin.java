/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.condominiomodel.Pessoa;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author darla
 */
@Named(value = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {
    
    private Pessoa pessoaAutenticada;
    @EJB
    private PessoaDAO<Pessoa> dao;
    private String pessoa;
    private String senha;
    
    public ControleLogin(){
        
    }
    
    public String irPaginaLogin(){
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        try {
            HttpServletRequest request = (HttpServletRequest)
                    FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(this.pessoa, this.senha);
            if (request.getUserPrincipal() != null){
                pessoaAutenticada = 
                        dao.getObjectByID(request.getUserPrincipal().getName());
                Util.mensagemInformacao("Login realizado com sucesso!");               
                pessoa = "";
                senha = "";                        
            }            
            return "/index?faces-redirect=true";
        } catch (Exception e){
            Util.mensagemErro("Pessoa ou senha inválidos! " + Util.getMensagemErro(e));
            return "/login";
        }            
    }
    
    public String efetuarLogout(){
        try {
            pessoaAutenticada = null;
            HttpServletRequest request = (HttpServletRequest)
                    FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.logout();          
            return "/index?faces-redirect=true";
        } catch (Exception e){
            Util.mensagemErro("Erro ao fazer logout! " + Util.getMensagemErro(e));
            return "/index?faces-redirect=true";
        }          
    }

    public Pessoa getPessoaAutenticada() {
        return pessoaAutenticada;
    }

    public void setPessoaAutenticada(Pessoa pessoaAutenticada) {
        this.pessoaAutenticada = pessoaAutenticada;
    }

    public PessoaDAO<Pessoa> getDao() {
        return dao;
    }

    public void setDao(PessoaDAO<Pessoa> dao) {
        this.dao = dao;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

}
