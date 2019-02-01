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
    public ArrayList<Cliente> readAll_Cliente(){
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
            System.err.println("[Cliente] - Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("[Cliente] - Erro geral " + ex.getMessage());
        }
        return null;
    }
    public boolean insertAll_Cliente(ArrayList<Cliente> vetCli){
        //mandar para o Banco.16:27:26	delete from dbzivi.Tbl_Cliente where Nome = 'Denise'	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00080 sec

      
        try{
            //inserindo
            String sql = "INSERT INTO dbzivi.Cliente (nome, idade, endereco, id_conta) values (?,?,?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            
            for(Cliente c: vetCli){
                //posicoes na tabela do BD
                ps.setString(1, c.getNome());
                ps.setInt(2, c.getIdade());
                ps.setString(3, c.getEndereco());
                ps.setInt(4, c.getN_conta());
                ps.executeUpdate();
            }  
            ps.close();
            return true;
                    
        }catch(SQLDataException ex){
            System.err.println("[Cliente] - Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("[Cliente] - Erro geral " + ex.getMessage());
        }
        return false;
    }
    public Cliente findClienteDB (String nomeParaBuscar, int contaParaBuscar){
        if(contaParaBuscar > 0){
            try{
                String sql = "SELECT * FROM Cliente where id_conta = "+ contaParaBuscar;
                PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); 

                ResultSet rs = ps.executeQuery();

                Cliente cli = new Cliente();
                if(rs.next()){

                    cli.setNome(rs.getString("nome")); //nome do atributo na tabela.
                    cli.setIdade(rs.getInt("idade"));
                    cli.setEndereco(rs.getString("endereco"));
                    cli.setN_conta(rs.getInt("id_conta"));
                }
                ps.close();
                return cli;// lista.get(0);

            }catch(SQLDataException ex){
                System.err.println("[Cliente] - Erro ao recuperar dados "+ex.getMessage());
            }catch(Exception ex){
                System.err.println("[Cliente] - Erro geral " + ex.getMessage());
            }
        }else{
                try{
                String sql = "SELECT * FROM Cliente where nome = '"+nomeParaBuscar+"'";
                PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); 

                ResultSet rs = ps.executeQuery();

                Cliente cli = new Cliente();
                if(rs.next()){

                    cli.setNome(rs.getString("nome")); //nome do atributo na tabela.
                    cli.setIdade(rs.getInt("idade"));
                    cli.setEndereco(rs.getString("endereco"));
                    cli.setN_conta(rs.getInt("id_conta"));
                    //lista.add(cli);
                    //fazer isto para todos os atributos
                }
                ps.close();
                return cli;// lista.get(0);

            }catch(SQLDataException ex){
                System.err.println("[Cliente] - Erro ao recuperar dados "+ex.getMessage());
            }catch(Exception ex){
                System.err.println("[Cliente] - Erro geral " + ex.getMessage());
            }
        
        }
        
        return null;
    
        
    }
    
   
    
}
