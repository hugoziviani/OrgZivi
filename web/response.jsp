<%-- 
    Document   : response
    Created on : Feb 2, 2019, 2:22:03 PM
    Author     : hz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="Cliente_class" scope="session" class="Model.Cliente" />
        <jsp:setProperty name="Cliente_class" property="nome"/>
        <h1>Hello, <jsp:getProperty name="Cliente_class" property="nome" />!</h1>
        
    </body>
</html>
