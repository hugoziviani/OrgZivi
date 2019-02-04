/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*; //para independer do BD

/**
 *
 * @author hz
 * permite que a gente envie os comandos e receba os resultados da conexao com o BD
 */
public class DataSource {
    //obj da conexao
    private String hostname;
    private int porta;
    private String database;
    private String username;
    private String password;
    private Connection conection;
    
    
    public DataSource(){
        //pedido de conexão
        try{
            hostname = "localhost";
            porta    =  3306;
            database = "dbzivi";
            username = "root";
            password = "mysql309309";
            //concatenar para formar a string de conexão
            String url = "jdbc:mysql://"+hostname+":"+porta+"/"+database;
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //registro do driver no banco
            conection = DriverManager.getConnection(url, username, password);
            
            System.out.println("DEU CERTO!!");
            
            
            
        }catch(SQLException ex){
            System.err.println("Erro na conexão com o BD" + ex.getMessage());
        }catch(Exception ex){
            System.err.println("Erro geral" + ex.getMessage());
        }
    
    }
    public Connection getConnection(){
        return this.conection;
    }
    public void closeDataSource(){
        try{
            conection.close();
            
        }catch(Exception ex){
            System.err.println("Erro ao desconectar..."+ex.getMessage());
        }
    }
    
    
           
    
}
