<%-- 
    Document   : home
    Created on : Jun 8, 2022, 8:34:53 PM
    Author     : 1999k
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    InitialContext ic = new InitialContext();
    ic.lookup("java:global/EJBModuleBCDday01/HelloSessionBean");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
