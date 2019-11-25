<%-- 
    Document   : UpdateProduct
    Created on : Nov 22, 2019, 12:29:14 PM
    Author     : casper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <c:forEach var="item" items="${parameters}" varStatus="paramCounter">
            <c:out value="${item.toString()}"></c:out>
        </c:forEach>
        
        <c:out value="${size}"></c:out>
        <c:out value="${parameters.toString()}"></c:out>
        
    </body>
</html>
