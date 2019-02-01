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
    
    public ArrayList<Transacao> readAll_Transacao(){
        try{
            String sql = "SELECT * FROM Transacao";//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Transacao> lista = new ArrayList<Transacao>();
            while(rs.next()){
                Transacao trans = new Transacao();
                trans.setId_conta(rs.getInt("id_conta")); //nome do atributo na tabela.
                trans.setData_hora(rs.getString("data_hora"));
                trans.setValor(rs.getFloat("valor"));    
                lista.add(trans);
                //fazer isto para todos os atributos
            }
            ps.close();
            return lista;
                    
        }catch(SQLDataException ex){
            System.err.println("[Transacao] - Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("[Transacao] - Erro geral " + ex.getMessage());
        }
        return null;
    }
    public boolean insertAll_Transacao(ArrayList<Transacao> vetTransacao){
        //mandar para o Banco.16:27:26	delete from dbzivi.Tbl_Cliente where Nome = 'Denise'	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00080 sec

      
        try{
            //inserindo
            String sql = "INSERT INTO dbzivi.Transacao (id_conta, data_hora, valor) values (?,?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            
            for(Transacao c: vetTransacao){
                //posicoes na tabela do BD
                ps.setInt(1, c.getId_conta());
                ps.setString(2, c.getData_hora());
                ps.setFloat(3, c.getValor());

                ps.executeUpdate();
            }  
            ps.close();
            return true;
                    
        }catch(SQLDataException ex){
            System.err.println("[Conta] - Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("[Conta] - Erro geral " + ex.getMessage());
        }
        return false;
    }
    
    //public boolean findContaNoBD()
    
}
