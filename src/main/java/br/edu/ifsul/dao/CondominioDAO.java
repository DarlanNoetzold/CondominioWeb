/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Condominio;
import br.edu.ifsul.converters.ConverterOrdem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author darlan
 */
@Stateful
public class CondominioDAO <TIPO> extends DAOGenerico<Condominio> implements Serializable {
    public CondominioDAO(){
        super();
        classePersistente = Condominio.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);        
    }
    
    @Override
    public Condominio getObjectByID(Object id) throws Exception {
        Condominio obj = em.find(Condominio.class, id);
        obj.getUnidadeCondominal().size();
        return obj;
    }    
    
    public List<Condominio> getListaObjetosCompleta(){
        String jpql = "select distinct t from condominio t left join fetch t.unidadeCondominal order by t.id";
        return em.createQuery(jpql).getResultList();
    }
}
