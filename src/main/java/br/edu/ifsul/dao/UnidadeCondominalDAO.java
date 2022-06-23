/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.UnidadeCondominal;
import br.edu.ifsul.converters.ConverterOrdem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author darlan
 */
@Stateful
public class UnidadeCondominalDAO<TIPO> extends DAOGenerico<UnidadeCondominal> implements Serializable {
    public UnidadeCondominalDAO(){
        super();
        classePersistente = UnidadeCondominal.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("numero", "Numero", "like"));
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }
    
    @Override
    public UnidadeCondominal getObjectByID(Object id) throws Exception {
        UnidadeCondominal obj = em.find(UnidadeCondominal.class, id);
        // uso para evitar o erro de lazy inicialization exception
        return obj;
    }    
    
    public List<UnidadeCondominal> getListaObjetosCompleta(){
        String jpql = "select distinct t from unidade_condominal t order by t.id";
        return em.createQuery(jpql).getResultList();
    }
}
