/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.UnidadeCondominal;
import java.io.Serializable;
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
    }
}
