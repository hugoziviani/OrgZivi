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
            String sql = "SELECT * FROM Tbl_Cliente";//comando para ir na tabela do BD
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
            return lista;
                    
        }catch(SQLDataException ex){
            System.err.println("Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("Erro geral " + ex.getMessage());
        }
        return null;
    }
}
