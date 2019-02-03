<%-- 
    Document   : cadastroCliente
    Created on : Feb 3, 2019, 4:27:42 PM
    Author     : hz
--%>

<%@page import="MainTeste.MainTeste"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="javax.swing.plaf.OptionPaneUI"%>
<%@page import="Model.*"%>
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
        <input type="number" name ="idade">
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
            }catch(RuntimeException e){
                e.getMessage();
            }
            
            //novoCliente.setIdade(Integer.parseInt(idade));
            
            //novoCliente.setIdade();
            //novoCliente.setEndereco(request.getParameter("endereco"));
            //novoCliente.setN_conta(Integer.parseInt(request.getParameter("nome")));
            
            
            if(novoCliente.getNome() != null) {
                
                out.print("\n"+ novoCliente.getNome() + ", ZiviBank te dá as boas vindas!");
            }
        %>
    </body>
</html>
