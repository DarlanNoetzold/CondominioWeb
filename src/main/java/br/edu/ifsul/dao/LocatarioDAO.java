/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Locatario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author darlan
 */
@Stateful
public class LocatarioDAO <TIPO> extends DAOGenerico<Locatario> implements Serializable {
    
    public LocatarioDAO(){
        super();
        classePersistente = Locatario.class;
    }
}
