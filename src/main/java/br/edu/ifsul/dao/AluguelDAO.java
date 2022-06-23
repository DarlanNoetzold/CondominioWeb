/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Aluguel;
import br.edu.ifsul.converters.ConverterOrdem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author darla
 */
@Stateful
public class AluguelDAO <TIPO> extends DAOGenerico<Aluguel> implements Serializable {
    public AluguelDAO(){
        super();
        classePersistente = Aluguel.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("valor", "Valor", "like"));
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);  
    }
    
    
    @Override
    public Aluguel getObjectByID(Object id) throws Exception {
        Aluguel obj = em.find(Aluguel.class, id);
        obj.getMensalidades().size();
        return obj;
    }    
    
    public List<Aluguel> getListaObjetosCompleta(){
        String jpql = "select distinct t from aluguel t order by t.id";
        return em.createQuery(jpql).getResultList();
    }
}
