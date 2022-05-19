/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Recurso;
import java.io.Serializable;
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
    }
}
