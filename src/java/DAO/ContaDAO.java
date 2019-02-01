package DAO;

import Model.Conta;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class ContaDAO {
    private DataSource dataSource;
    public ContaDAO(DataSource dataSource){
        //
        this.dataSource = dataSource; 
        
    }
    
    
     public ArrayList<Conta> readAll(){
        try{
            String sql = "SELECT * FROM Conta";//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Conta> lista = new ArrayList<Conta>();
            while(rs.next()){
                Conta conta = new Conta();
             
                conta.setId_conta(rs.getInt("id_conta"));
                conta.setSaldo(rs.getDouble("saldo"));
                
                lista.add(conta);
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
