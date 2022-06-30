/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Permissao;
import br.edu.ifsul.converters.ConverterOrdem;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author darla
 */
@Stateful
public class PermissaoDAO<TIPO>  extends DAOGenerico<Permissao> implements Serializable {
    
    public PermissaoDAO(){
        super();
        classePersistente = Permissao.class;
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("descricao", "Descrição", "like"));
        ordemAtual = listaOrdem.get(0);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);              
    }

}
