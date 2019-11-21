<%-- 
    Document   : Error
    Created on : Nov 20, 2019, 7:23:25 PM
    Author     : casper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>OOPS SOMETHING  WENT  WRONG</h1>
        <c:out value="${requestScope.error}"></c:out>
        <br>
        <c:out value="${requestScope.cause}"></c:out>
        <c:forEach var="trace" items="${requestScope.stacktrace}">
            <c:out value="${trace}"></c:out>
            <br>
        </c:forEach>
        
    </body>
</html>
