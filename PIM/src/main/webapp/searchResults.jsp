<%-- 
    Document   : searchResults
    Created on : 21. nov. 2019, 09.49.42
    Author     : jenso
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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


        <form action="FrontController">
            <input type="hidden" name="cmd" value="gotoUpdateProduct">
            <div class="row" id="items">
                <div class="col-lg-1">
                    <div class="position-fixed"><button type="submit" class="btn btn-primary">Edit</button>
                    </div>

                </div>
                <div class="col-lg-11 col-xs-1">

                    <% ArrayList<Product> products = (ArrayList) request.getAttribute("productList");%>
                    <% int counter; %>
                    <% HashMap<String, Integer> countMap = new HashMap<>();

                        for (Product product : products) {

                            if (countMap.containsKey(product.getType())) {
                                countMap.put(product.getType(), countMap.get(product.getType()) + 1);
                            } else {
                                countMap.put(product.getType(), 1);
                            }
                        }
                    %>

                    <%
                        int placement = 0;
                        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                            int value = entry.getValue();


                    %>
                    <table class="table"> 
                        <thead> 
                            <% for (int i = 0; i < products.get(placement).getFields().size(); i++) {%>

                        <th>    <%=products.get(placement).getFields().get(i)%> </th>
                            <% } %>    
                        </thead>    

                        <tr>
                            <%     for (int j = placement; j < value + placement; j++) { %>

                            <%     for (int t = 0; t < products.get(j).getFields().size(); t++) {%>
                            <td>    <%=products.get(j).getFieldsValues().get(t)%>               </td>


                            <% }%>
                            <td> 
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="<%=products.get(j).getID()%>"
                                           id="defaultCheck1" name="selectedEdit">
                                    </td>
                                    <td>
                                        <div class="form-check">
                                            <button type="submit" class="btn btn-primary" name="selectedProduct"
                                                    value="<%=products.get(j).getID()%>" onclick="buttonB_clickHandler(event)">Go To Product</button>
                                    </td>

                                    <td>
                                        <div class="form-check">
                                            <button type="submit" class="btn btn-primary" name="selectedEdit"
                                                    value="<%=products.get(j).getID()%>" onclick="buttonA_clickHandler(event)">Edit Product</button>
                                    </td>

                        </tr>
                        <% } %>
                    </table>
                    <% placement = placement + value;
                           }%>     




                </div>
            </div>                  
        </form>
                           <script type="text/javascript" src="buttonFunction.js"></script>

    </body>
</html>
