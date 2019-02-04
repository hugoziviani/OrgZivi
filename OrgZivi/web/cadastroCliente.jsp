<%-- 
    Document   : cadastroCliente
    Created on : Feb 3, 2019, 4:27:42 PM
    Author     : hz
--%>


<%@page import="MainTeste.MainTeste"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="javax.swing.plaf.OptionPaneUI"%>
<%@page import="Model.*"%>
<%@page import="MainTeste.*"%>
<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <form action="cadastroCliente.jsp" method="post">
       
        <div align ="center"><h2> Cadastro de Cliente </h2></div>
        <jsp:useBean id="novoCliente" scope="request" class="Model.Cliente" />
        <p><b>Nome:</b></p>
            <input type="text" name ="nome">
        <p><b>Idade:</b></p>
        <input type="text" name ="idade">
        <p><b>Endereço:</b></p>    
            <input type="text" name ="endereco">
        <p><b>Número da conta:</b></p>
            <input type="text" name ="id_conta">
        <br><br>
            <input type="submit" value="Salvar">
            
        </form>
      
        <% 
            try{
                novoCliente.setNome(request.getParameter("nome"));
                String idade = request.getParameter("idade");
                novoCliente.setIdade(Integer.parseInt(idade));
                novoCliente.setEndereco(request.getParameter("endereco"));
                novoCliente.setN_conta(Integer.parseInt(request.getParameter("id_conta")));
                
                MainTeste.insereCliente(novoCliente);
                
            }catch(RuntimeException e){
                e.getMessage();
            }
            
            //obj da conexao
            String hostname;
            int porta;
            String database;
            String username;
            String password;
            Connection conection =null;


            
                //pedido de conexão
                try{

                    hostname = "localhost";
                    porta    =  3306;
                    database = "dbzivi";
                    username = "root";
                    password = "hugo309309";
                    //concatenar para formar a string de conexão
                    String url = "jdbc:mysql://"+hostname+":"+porta+"/"+database+"&useSSL=FALSE";
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); //registro do driver no banco
                    conection = DriverManager.getConnection(url, username, password);
                    System.out.println("DEU CERTO!!");
                }catch(SQLException ex){
                    System.err.println("Erro na conexão com o BD " + ex.getMessage());
                }catch(Exception ex){
                    System.err.println("Erro geral" + ex.getMessage());
                }

            
                
                
                try {
            //inserindo
            String sql = "INSERT INTO dbzivi.Cliente (nome, idade, endereco, id_conta) values (?,?,?,?)";

            PreparedStatement ps = conection.prepareStatement(sql);
                    //.prepareStatement(sql); // traduza esse comando para um do sql

            
                //posicoes na tabela do BD
                ps.setString(1, novoCliente.getNome());
                ps.setInt(2, novoCliente.getIdade());
                ps.setString(3, novoCliente.getEndereco());
                ps.setInt(4, novoCliente.getN_conta());
                ps.executeUpdate();
            
            ps.close();
            

        } catch (SQLDataException ex) {
            System.err.println("[Cliente] - Erro ao recuperar dados " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[Cliente] - Erro geral " + ex.getMessage());
        }
                
                
                
                
                
           
            
            if(novoCliente.getNome() != null) {
                
                out.print("\n"+
                        novoCliente.getNome() + " " +
                        novoCliente.getEndereco() + " " +
                        ", ZiviBank te dá as boas vindas!");
            }
        %>
    </body>
</html>
