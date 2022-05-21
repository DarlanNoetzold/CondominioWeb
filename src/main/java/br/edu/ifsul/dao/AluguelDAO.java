/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Aluguel;
import java.io.Serializable;
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
    }
}
