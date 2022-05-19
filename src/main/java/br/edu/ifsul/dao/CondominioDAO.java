/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Condominio;
import java.io.Serializable;
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
    }
}
