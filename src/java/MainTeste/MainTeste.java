/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTeste;

import DAO.ClienteDAO;
import DAO.ContaDAO;
import DAO.DataSource;
import DAO.TransacaoDAO;
import Model.Cliente;
import Model.Conta;
import Model.Transacao;
import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class MainTeste {
    
    public static void main (String args[]){
        DataSource ds = new DataSource();
        //recuperar a lista de clientes
        
        /*
        ArrayList <Cliente> cliInsert = new ArrayList<Cliente>();
        cliInsert.add(new Cliente("Roberval1", 337, "Rua HAHAHAHAHAHA", 24904));
        cliInsert.add(new Cliente("Roberval2", 337, "Rua hehehehehe", 22333));
        */
        
        
        
        
        
        
        ClienteDAO cliDao = new ClienteDAO (ds);
        ContaDAO contaDao = new ContaDAO (ds);
        TransacaoDAO transacaoDao = new TransacaoDAO (ds);
        
        ArrayList <Cliente> listaCli = cliDao.readAll_Cliente();
        ArrayList <Conta> listaCon = contaDao.readAll_Contas();
        ArrayList <Transacao> listaTrans = transacaoDao.readAll();
        
        
        //if(cliDao.insertAll_Cliente(cliInsert)) System.out.println("Clientes Inseridos");
        
        
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
        
        System.out.println("\n\nTRANSACOES:::\n\n");
        if(listaTrans !=null){
            for(Transacao tr: listaTrans){
                tr.printTransacao();
                System.out.println("");
            }
        }
        
        
        
        ds.closeDataSource();//fecha a conexão com o BD
    }
    
}
