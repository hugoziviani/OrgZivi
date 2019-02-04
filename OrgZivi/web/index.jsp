<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Jan 31, 2019, 10:29:39 AM
    Author     : hz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ZiviBank</title>
    </head>
    <body>
        <form action ="cadastroCliente.jsp" >
        <h1>Bem vindo ao ZiviBank - aqui seu dinheiro rende!</h1>
        <label>Escolha sua opção:</label>
        <br><br><br><br>
        <input type="submit" value="Novo Cliente"/>
        </form>
        <br>
        <form action="usuarioSalvo.jsp">
            <input type="submit" value="Consulta de Conta" />
        </form>
        <br>
        <form action="transacoesZiviBank.jsp">
            <input type="submit" value="Transações do ZiviBank" />
        </form>    
       
        

    </body>
</html>
