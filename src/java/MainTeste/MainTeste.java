/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTeste;

import DAO.ClienteDAO;
import DAO.DataSource;
import Model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class MainTeste {
    
    public static void main (String args[]){
        DataSource ds = new DataSource();
        //recuperar a lista de clientes
        
        ClienteDAO cliDao = new ClienteDAO (ds);
        
        ArrayList <Cliente> lista = cliDao.readAll();
        
        if(lista!=null){
            for(Cliente c : lista){
                System.out.println("Nome: "+ c.getNome()+"Idade: "+c.getIdade());
            }
        }
        ds.closeDataSource();//fecha a conexão com o BD
    }
    
}
