<%-- 
    Document   : authorsList
    Created on : Feb 16, 2018, 1:26:55 PM
    Author     : Goran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Authors</title>
    </head>
    <body>
        <h2>Authors</h2>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>LastName</th>
            </tr>
            <c:forEach items="${authors}" var="a">
            <tr>
                <td>${a.id}</td>
                <td>${a.name}</td>
                <td>${a.lastName}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
