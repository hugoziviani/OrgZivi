/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Transacao;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class TransacaoDAO {

    private DataSource dataSource;
    public TransacaoDAO(DataSource dataSource){
        //
        this.dataSource = dataSource; 
        
    }
    public ArrayList<Transacao> readAll(){
        try{
            String sql = "SELECT * FROM Cliente";//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Transacao> lista = new ArrayList<Transacao>();
            while(rs.next()){
                Transacao trans = new Transacao();
                trans.setId_conta(rs.getInt("id_conta")); //nome do atributo na tabela.
                trans.setData_hora(rs.getString("data_hora"));
                trans.setValor(rs.getDouble("valor"));    
                lista.add(trans);
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
