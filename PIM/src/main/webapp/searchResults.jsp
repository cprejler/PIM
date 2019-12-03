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

        <div class="container-fluid" id="page-wrapper">

<<<<<<< HEAD
            <div class="container">
                <div class="row mx-auto px-md-5">
                    <div class="col">
                        <div class="search-bar">
                            <form action="FrontController">
=======
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
>>>>>>> 23db87588d1905564c5759bde607a6b078a80388

                                <input type="text" name="searchItem">
                                <input type="hidden" name="cmd" value="search">

                                <input type="submit" name="button" value="Search">
                            </form>

                        </div>
                    </div>
                </div>
        
        <form action="FrontController">
            <input type="hidden" name="cmd" value="" id="hiddenId">
            <div class="row" mx-auto>
                <div class="col-lg-1 mx-auto">
                    <div class="px-md-5">
                        <button type="submit" class="btn btn-primary" onclick="buttonA_clickHandler(event)">Bulk Edit Products</button>
                    </div>
                </div>
            </div>

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

                int placement = 0;
                for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                    int value = entry.getValue();


            %>
             <div class="col-lg">
                                <div class="row">

                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                <thead class="thead"> 
                    <% for (int i = 0; i < products.get(placement).getFields().size(); i++) {%>

<<<<<<< HEAD
                <th>    <%=products.get(placement).getFields().get(i)%> </th>
                    <% } %>    
                </thead>    
=======
                                    <td>
                                        <div class="form-check">
                                            <button type="submit" class="btn btn-primary" name="selectedEdit"
                                                    value="<%=products.get(j).getID()%>" onclick="buttonA_clickHandler(event)">Edit Product</button>
                                    </td>
>>>>>>> 23db87588d1905564c5759bde607a6b078a80388

                <tr>
                    <%     for (int j = placement; j < value + placement; j++) {

                                    for (int t = 0; t < products.get(j).getFields().size(); t++) {%>
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

<<<<<<< HEAD
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
                        </div>                    
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
<script type="text/javascript" src="buttonFunction.js"></script>
</body>
=======
                </div>
            </div>                  
        </form>
                           <script type="text/javascript" src="buttonFunction.js"></script>

    </body>
>>>>>>> 23db87588d1905564c5759bde607a6b078a80388
</html>
