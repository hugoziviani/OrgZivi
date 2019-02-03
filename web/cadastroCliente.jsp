<%-- 
    Document   : cadastroCliente
    Created on : Feb 3, 2019, 4:27:42 PM
    Author     : hz
--%>

<%@page import="Model.*"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <form action="cadastroCliente.jsp" method="get">
       
        <div align ="center"><h2> Cadastro de Cliente </h2></div>
        
        <p><b>Nome:</b></p>
            <input type="text" name ="nome">
        <p><b>Idade:</b></p>
            <input type="number" name ="idade">
        <p><b>Endereço:</b></p>    
            <input type="text" name ="endereco">
        <p><b>Número da conta:</b></p>
            <input type="number" name ="id_conta">
            <br>
            <input type="submit" value="Salvar">
        </form>
        
        
        
        
        <% 
            Cliente novo = new Cliente();
            
            
            novo.setNome(request.getParameter("nome"));
            if(novo.getNome() != null) {
                novo.printCliente();
                out.print(" , ZiviBank te dá as boas vindas!");
            }
            
        %>
    </body>
</html>
