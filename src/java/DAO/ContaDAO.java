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
    
        this.dataSource = dataSource; 
        
    }
    
    public boolean insertAll_Contas(ArrayList<Conta> vetConta){
        //mandar para o Banco.16:27:26	delete from dbzivi.Tbl_Cliente where Nome = 'Denise'	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00080 sec

      
        try{
            //inserindo
            String sql = "INSERT INTO dbzivi.Conta (id_conta, saldo) values (?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            
            for(Conta c: vetConta){
                //posicoes na tabela do BD
                ps.setInt(1, c.getId_conta());
                ps.setFloat(2, c.getSaldo());

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
    public boolean insertOne_Contas(Conta c){
        try{
            //inserindo
            String sql = "INSERT INTO dbzivi.Conta (id_conta, saldo) values (?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            
            
                //posicoes na tabela do BD
                ps.setInt(1, c.getId_conta());
                ps.setFloat(2, c.getSaldo());

                ps.executeUpdate();
            
            ps.close();
            return true;
                    
        }catch(SQLDataException ex){
            System.err.println("[Conta] - Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("[Conta] - Erro geral " + ex.getMessage());
        }
        return false;
        
    }
    public ArrayList<Conta> readAll_Contas(){
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
                conta.setSaldo(rs.getFloat("saldo"));
                
                lista.add(conta);
                //fazer isto para todos os atributos
            }
            ps.close();
            return lista;
                    
        }catch(SQLDataException ex){
            System.err.println("[Conta] - Erro ao recuperar dados "+ex.getMessage());
        }catch(Exception ex){
            System.err.println("[Conta] - Erro geral " + ex.getMessage());
        }
        return null;
    }
    public Conta readOne_Contas (int contaParaBuscar){
            try{
                String sql = "SELECT * FROM Conta where id_conta = "+ contaParaBuscar;
                PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); 

                ResultSet rs = ps.executeQuery();

                Conta con = new Conta();
                if(rs.next()){
                    con.setId_conta(rs.getInt("id_conta"));
                    con.setSaldo(rs.getFloat("saldo"));
                }
                ps.close();
                return con;// lista.get(0);

            }catch(SQLDataException ex){
                System.err.println("[Conta] - Erro ao recuperar dados "+ex.getMessage());
            }catch(Exception ex){
                System.err.println("[Conta] - Erro geral " + ex.getMessage());
            }
            return null;
    }
    
    public boolean update_Conta(Conta antiga, Conta nova){
        
            try{
                
                String sql = "UPDATE Conta SET id_conta = ? , saldo = ?  WHERE id_conta = ?";

                PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
                    //posicoes na tabela do BD
                    ps.setInt(1, nova.getId_conta());
                    ps.setFloat(2, nova.getSaldo());
                    ps.setInt(3, antiga.getId_conta());
                    ps.executeUpdate();
                ps.close();
                System.out.println("Conta atualizada com sucesso");
                return true;

            }catch(SQLDataException ex){
                System.err.println("[Conta] - Erro ao atualizar dados "+ex.getMessage());
            }catch(Exception ex){
                System.err.println("[Conta] - Erro geral " + ex.getMessage());
            }
        
        return false;
        
    }
    public boolean delete_Conta(Conta c){
        if(c.getId_conta() > 0){
            try {
                String sql = "DELETE FROM Conta WHERE id_conta = ?";
                PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
                ps.setInt(1, c.getId_conta());
                ps.executeUpdate();
                ps.close();
                return true;

            } catch (SQLDataException ex) {
                System.err.println("[Conta] - Erro ao excluir dados " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("[Conta] - Erro geral " + ex.getMessage());
            }
        }
        return false;
    }
    
}
