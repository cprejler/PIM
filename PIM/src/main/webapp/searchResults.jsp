<%-- 
    Document   : searchResults
    Created on : 21. nov. 2019, 09.49.42
    Author     : jenso
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="businesslogic.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
       <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>BootStrap test</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    
    <body>
        <form action="FrontController">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/index.html">PIM</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Action
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                
                                <button type="submit" class="dropdown-item" name="cmd" value="gotoInsertProduct">Insert
                                    Product</button>
                                <button type="submit" class="dropdown-item" name="cmd" value="ShowProducts">Show
                                    Products</button>

                                <div class="dropdown-divider"></div>
                                <button type="submit" class="dropdown-item" name="cmd" value="exportJSON">Export
                                    Data</button>

                            </div>
                        </li>

                    </ul>
                </div>
            </nav>
        </form>
        <% /* 
         <div class="col-lg-12" id="items">
                <form action="Frontcontroller">
                    <input type="hidden" name="cmd" value="editItem">
                    <div class="row" id="items">
                        <div class="col-lg-1">
                            <div class="position-fixed"><button type="submit" class="btn btn-primary">Edit</button>
                            </div>
                        </div>
                        <div class="col-lg-11 col-xs-1">

                            <c:forEach  var="tableName" items="${requestScope.tableNames}" varStatus="tableCount">
                            <table class="table">
                                <thead>
                                    
                                    <c:forEach var="field" items="${products.get(tableCount.index).get(0).getFields()}">
                                    <th>${field}</th>
                                    </c:forEach>
                                    

                                <th>Edit</th>
                                
                                </thead>
                                <tbody>
                                    <c:forEach var="product" items="${requestScope.products.get(tableCount.index)}">
                                        <tr>
                                            <c:forEach var="fieldValues" items="${product.getFieldsValues()}">
                                                <td>${fieldValues}</td>
                                            </c:forEach>
                                            <td>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" value="${fieldValues}"
                                                           id="defaultCheck1" name="selectedEdit">

                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            
                            </c:forEach>
                        </div>
                    </div>
                </form>
            </div>
            */ %>
            
            <form action="FrontController">
                <input type="hidden" name="cmd" value="editItem">
                <div class="row" id="items">
                    <div class="col-lg-1">
                        <div class="position-fixed"><button type="submit" class="btn btn-primary">Edit</button>
                        </div>
                    </div>
                    <div class="col-lg-11 col-xs-1">
                        <table class="table">
                            <thead>
                                <% ArrayList<Product> productlist = (ArrayList)request.getAttribute("productList");
                                Product product1 = productlist.get(0);
                                for (String field : product1.getFields()){
                                    
                                    
                                }
                                %>
                                
                                
                        
                
            </form>




        </div>

        
    </body>
</html>
