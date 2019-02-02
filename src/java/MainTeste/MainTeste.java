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
import java.util.Date;

/**
 *
 * @author hz
 */
public class MainTeste {
    
    public static void main (String args[]){
        
        Date dataAtual = new Date();
        
        int n_conta = 40041;
        String identificcao = dataAtual.toString()+"-"+ String.valueOf(n_conta);
        
        insereTransacao(new Transacao (identificcao, n_conta, 2.3f));
    }
    // CLIENTE
    public static void insereCliente (Cliente c){
        DataSource ds = new DataSource();
        ClienteDAO cliDao = new ClienteDAO (ds);
        if(cliDao.insertOne_Cliente(c))System.out.println("Cliente " + c.getNome() + " inserido com sucesso!");
    }
    public static void buscaCliente (String nome, int conta){
        DataSource ds = new DataSource();
        ClienteDAO cliDao = new ClienteDAO(ds);
        Cliente buscado = new Cliente();
        buscado = cliDao.readOne_Cliente(nome, conta);
        buscado.printCliente();
    } 
    public static void atualizaCliente (){
        DataSource ds = new DataSource();
        ClienteDAO cliDao = new ClienteDAO(ds);
        
        cliDao.update_Cliente(cliDao.readOne_Cliente("Hugo1", 0) ,new Cliente("Jozias", 23, "Jordel manancebis", 100000));//) System.out.println("Cliente atualizado com sucesso");;
    
    }
    public static void removeCliente (){
        DataSource ds = new DataSource();
        ClienteDAO cliDao = new ClienteDAO (ds);
        cliDao.remove_Cliente(new Cliente ("Hugo4",0, "", 0));
    }
    
    
    // CONTA
    public static void insereConta (Conta c){
        DataSource ds = new DataSource();
        ContaDAO contaDao = new ContaDAO(ds);
        if(contaDao.insertOne_Contas(c)) System.out.println("Conta " + c.getId_conta()+ " inserida com sucesso!");
    
    }
    public static void buscaConta (int conta){
        DataSource ds = new DataSource();
        ContaDAO contaDao = new ContaDAO(ds);
        Conta buscada = new Conta();
        buscada = contaDao.readOne_Contas(conta);
        buscada.printConta();
    }
    public static void atualizaConta (){
        DataSource ds = new DataSource();
        ContaDAO contaDao = new ContaDAO(ds);
        contaDao.update_Conta(new Conta(400000, 0), new Conta (400000, 33333.3f));
    }
    public static void removeConta (){
        DataSource ds = new DataSource();
        ContaDAO contaDao = new ContaDAO(ds);
        contaDao.delete_Conta(new Conta(32000, 0));
    
    }
    
    
    // TRANSACOES
    public static void buscaTransacoes (int conta){
        DataSource ds = new DataSource();
        TransacaoDAO tranDao = new TransacaoDAO(ds);
        ArrayList <Transacao> tr = new ArrayList<Transacao>();
        tr = tranDao.readOne_Transacoes(conta);
        for(Transacao t : tr){
            t.printTransacao();
        }
        
    }
    public static void insereTransacao (Transacao t){
        DataSource ds = new DataSource();
        TransacaoDAO transDao = new TransacaoDAO(ds);
        if(transDao.insertOne_Transacao(t)) System.out.println("Transacao de " + t.getValor()+ " inserida com sucesso!");
    }
    public static void removeTransacao (Transacao t){
        DataSource ds = new DataSource();
        TransacaoDAO transDao = new TransacaoDAO(ds);
        if(transDao.delete_Transacao(t)) System.out.println("Transacao de " + t.getValor()+ " removida com sucesso!");
    
    
    
    }
    
    
    public void testesMain(){
    
    DataSource ds = new DataSource();
        //recuperar a lista de clientes
       
        /*
        ArrayList <Cliente> cliInsert = new ArrayList<Cliente>();
        cliInsert.add(new Cliente("Roberval1", 337, "Rua HAHAHAHAHAHA", 24904));
        cliInsert.add(new Cliente("Roberval2", 337, "Rua hehehehehe", 22333));
        ArrayList<Conta> contaInsert = new ArrayList<Conta>();
        contaInsert.add(new Conta(4004332, 220.99f));
        contaInsert.add(new Conta(4004334, 220.99f));
        contaInsert.add(new Conta(4004335, 220.99f));
        
        
        ArrayList <Transacao> transInsert = new ArrayList<Transacao>();
        transInsert.add(new Transacao(400329, "2/2/1900", 2.3f));
        transInsert.add(new Transacao(400329, "2/2/1900", 2.3f));
        transInsert.add(new Transacao(400329, "2/2/1900", 2.3f));
        transInsert.add(new Transacao(400329, "2/2/1900", 2.3f));
        
        */
        
        
        
        ClienteDAO cliDao = new ClienteDAO (ds);
        ContaDAO contaDao = new ContaDAO (ds);
        TransacaoDAO transacaoDao = new TransacaoDAO (ds);
        
        ArrayList <Cliente> listaCli = cliDao.readAll_Cliente();
        ArrayList <Conta> listaCon = contaDao.readAll_Contas();
        ArrayList <Transacao> listaTrans = transacaoDao.readAll_Transacao();
        
        
        //if(cliDao.insertAll_Cliente(cliInsert)) System.out.println("Clientes Inseridos");
        //if(contaDao.insertAll_Contas(contaInsert))System.out.println("Contas inseridas");
        //if(transacaoDao.insertAll_Transacao(transInsert))System.out.println("Transacoes inseridas");
        
        
        
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
