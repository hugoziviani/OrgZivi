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

    public TransacaoDAO(DataSource dataSource) {
        //
        this.dataSource = dataSource;

    }

    public boolean insertAll_Transacao(ArrayList<Transacao> vetTransacao) {
        //mandar para o Banco.16:27:26	delete from dbzivi.Tbl_Cliente where Nome = 'Denise'	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00080 sec

        try {
            //inserindo
            String sql = "INSERT INTO dbzivi.Transacao (idTransacao, id_conta, valor) values (?,?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql

            for (Transacao c : vetTransacao) {
                //posicoes na tabela do BD
                ps.setString(1, c.getIdTransacao());
                ps.setInt(2, c.getId_conta());
                ps.setFloat(3, c.getValor());
                ps.executeUpdate();
            }
            ps.close();
            return true;

        } catch (SQLDataException ex) {
            System.err.println("[Transacao] - Erro ao recuperar dados " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[Transacao] - Erro geral " + ex.getMessage());
        }
        return false;
    }

    public boolean insertOne_Transacao(Transacao tr) {

        try {
            String sql = "INSERT INTO dbzivi.Transacao (idTransacao, id_conta, valor) values (?,?,?)";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            
            ps.setString(1, tr.getIdTransacao());
            ps.setInt(2, tr.getId_conta());
            ps.setFloat(3, tr.getValor());
            ps.executeUpdate();

            ps.close();
            return true;

        } catch (SQLDataException ex) {
            System.err.println("[Transacao] - Erro ao inserir dados " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[Transacao] - Erro geral " + ex.getMessage());
        }
        return false;

    }

    public ArrayList<Transacao> readAll_Transacao() {
        try {
            String sql = "SELECT * FROM Transacao";//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Transacao> lista = new ArrayList<Transacao>();
            while (rs.next()) {
                Transacao trans = new Transacao();
                trans.setIdTransacao(rs.getString("idTransacao"));
                trans.setId_conta(rs.getInt("id_conta")); //nome do atributo na tabela.
                trans.setValor(rs.getFloat("valor"));
                lista.add(trans);
                //fazer isto para todos os atributos
            }
            ps.close();
            return lista;

        } catch (SQLDataException ex) {
            System.err.println("[Transacao] - Erro ao recuperar dados " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[Transacao] - Erro geral " + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Transacao> readOne_Transacoes(int numDaConta) {
        try {
            String sql = "SELECT * FROM Transacao where id_conta=" + numDaConta;//comando para ir na tabela do BD
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql); // traduza esse comando para um do sql
            //result set, conjunto, é a representacao do select
            ResultSet rs = ps.executeQuery(); // sempre aponta para uma posicao de antes dos resultados
            //se houver um registro ele começa recuperar antes deles
            ArrayList<Transacao> lista = new ArrayList<Transacao>();
            while (rs.next()) {
                Transacao trans = new Transacao();
                trans.setIdTransacao(rs.getString("idTransacao"));
                trans.setId_conta(rs.getInt("id_conta")); //nome do atributo na tabela.
                trans.setValor(rs.getFloat("valor"));
                lista.add(trans);
                //fazer isto para todos os atributos
            }
            ps.close();
            return lista;

        } catch (SQLDataException ex) {
            System.err.println("[Transacao] - Erro ao recuperar dados " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[Transacao] - Erro geral " + ex.getMessage());
        }
        return null;
    }

    public boolean delete_Transacao(Transacao t) {

        
            try {
                String sql = "DELETE FROM Transacao WHERE idTransacao = ?";
                PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
                ps.setString(1, t.getIdTransacao());
                
                ps.executeUpdate();
                ps.close();
                return true;

            } catch (SQLDataException ex) {
                System.err.println("[Transacao] - Erro ao excluir dados " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("[Transacao] - Erro geral " + ex.getMessage());
            }
        
        return false;
    }



}
