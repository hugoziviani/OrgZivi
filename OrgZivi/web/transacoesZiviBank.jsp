<%-- 
    Document   : transacoesZiviBank
    Created on : 04/02/2019, 18:06:01
    Author     : deniseziviani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transações ZiviBank</title>
    </head>
    <body>
        <form action="transacoesZiviBank.jsp">
            <h1>Escolha a transação a ser consultada</h1>
            <label>Listar clientes
                <input type="radio" name="listarClientes" value="" />
            </label>

            <label>Listar Saldos
                <input type="radio" name="listarSaldos" value="" />
            </label>
            <input type="submit" value="Buscar" />
        </form>
    </body>
</html>
