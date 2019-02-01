/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class ClienteDAO {
    //concentra todas as instrucoes SQL
    //retornar uma lista de clientes
    //conectar com o banco e passar para este cara aqui
    private DataSource dataSource;
    public ClienteDAO(DataSource dataSource){
        //
        this.dataSource = dataSource; 
        
    }
    public ArrayList<Cliente> readAll(){
        try{
            String sql = "SELECT * FROM Cliente";//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setNome(rs.getString("nome")); //nome do atributo na tabela.
                cli.setIdade(rs.getInt("idade"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setN_conta(rs.getInt("id_conta"));
                lista.add(cli);
                //fazer isto para todos os atributos
            }
            ps.close();
            return lista;
                    
        }catch(SQLDataException ex){
            System.err.println("Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("Erro geral " + ex.getMessage());
        }
        return null;
    }
    
    /*public boolean insertAll(Cliente c){
        //mandar para o Banco.16:27:26	delete from dbzivi.Tbl_Cliente where Nome = 'Denise'	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00080 sec

        
        try{
            String sql = "INSERT * INTO Tbl_Cliente";//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setIdade(rs.getInt("Idade")); //nome do atributo na tabela.
                cli.setNome(rs.getString("Nome"));
                lista.add(cli);
                //fazer isto para todos os atributos
            }
            ps.close();
            return true;
                    
        }catch(SQLDataException ex){
            System.err.println("Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("Erro geral " + ex.getMessage());
        }
        return false;
    } */
}
