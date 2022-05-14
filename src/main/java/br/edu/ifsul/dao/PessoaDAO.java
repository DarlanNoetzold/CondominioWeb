/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.condominiomodel.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author darlan
 */
@Stateful
public class PessoaDAO <TIPO> extends DAOGenerico<Pessoa> implements Serializable {
    
    public PessoaDAO(){
        super();
        classePersistente = Pessoa.class;
    }
}
