<%-- 
    Document   : download
    Created on : Oct 20, 2015, 10:27:58 AM
    Author     : itspe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
        <%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "must-revalidate");
response.setDateHeader("Expires",0);
%>
    </head>
    <body  >
        <form action="LogoutServlet" method="post">
            <select name="a">
                <option value="<£1"><£1</option>
                <option value=">£1">>£1</option>
            </select>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
