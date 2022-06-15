/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Recurso;
import br.edu.ifsul.converters.ConverterOrdem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author darla
 */
@Stateful
public class RecursoDAO <TIPO> extends DAOGenerico<Recurso> implements Serializable {
    public RecursoDAO(){
        super();
        classePersistente = Recurso.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("descricao", "Descricao", "like"));
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);   
    }
    
    @Override
    public Recurso getObjectByID(Object id) throws Exception {
        Recurso obj = em.find(Recurso.class, id);
        obj.getCondominios().size();
        return obj;
    }    
    
    public List<Recurso> getListaObjetosCompleta(){
        String jpql = "select distinct t from recurso t left join fetch t.condominios order by t.id";
        return em.createQuery(jpql).getResultList();
    }
}
