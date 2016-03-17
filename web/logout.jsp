<%-- 
    Document   : logout
    Created on : Oct 26, 2015, 12:11:09 PM
    Author     : itspe
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
       
        <title>JSP Page</title>
       <%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "must-revalidate");
response.setDateHeader("Expires",0);
%>
            
    </head>
    <body >
        <h1>you have successfully logged out</h1>
    </body>
</html>
