/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTeste;

import DAO.ClienteDAO;
import DAO.ContaDAO;
import DAO.DataSource;
import Model.Cliente;
import Model.Conta;
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
        ContaDAO contaDao = new ContaDAO (ds);
        
        ArrayList <Cliente> listaCli = cliDao.readAll();
        ArrayList <Conta> listaCon = contaDao.readAll();
        
        if(listaCli !=null){
            for(Cliente c : listaCli){
                c.printCliente();
                System.out.println("");
            }
        }
        System.out.println("\n\nCONTAS:::\n\n");
        if(listaCon !=null){
            for(Conta ct: listaCon){
            ct.printConta();
                System.out.println("");
            }
        }
        ds.closeDataSource();//fecha a conexão com o BD
    }
    
}
