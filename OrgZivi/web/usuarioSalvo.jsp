<%-- 
    Document   : usuarioSalvo
    Created on : Feb 3, 2019, 4:34:10 PM
    Author     : hz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <h1>Consulta de conta e cadastro</h1>
        <label><input type="radio" name="Número da conta" value="1" checked="checked" />Número da Conta</label> 
        <label><input type="radio" name="Nome do cliente" value="2" /> Nome do Cliente </label>
        <br><br>
        <input type="text" name="id_consulta" style="padding:10px" height="10" width="60" />
        <br><br>
        <input type="submit" value="Consultar" />
        
    </body>
</html>
