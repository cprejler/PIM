<%-- 
    Document   : test
    Created on : Nov 12, 2019, 9:08:13 PM
    Author     : casper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>ShowProducts</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body>

        <!-- NAVBAR -->
        <form action="FrontController">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">PIM</a>
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

            <div class="container">
                <div class="row mx-auto px-md-5">
                    <div class="col">
                        <div class="search-bar">
                            <form action="FrontController">

                                <input type="text" name="searchItem">
                                <input type="hidden" name="cmd" value="search">

                                <input type="submit" name="button" value="Search">
                            </form>

                        </div>
                    </div>
                </div>

                <script>
                    function buttonA_clickHandler(event) {
                        document.getElementById('hiddenId').value = "gotoUpdateProduct";
                    }
                    function buttonB_clickHandler(event) {
                        document.getElementById('hiddenId').value = "gotoSpecificProduct";
                    }
                    </script>

                    <form action="FrontController">
                        <input type="hidden" name="cmd" value="" id="hiddenId">
                        <div class="row" id="items">
                            <div class="col-lg-1">
                                <div class="px-md-5">
                                    <button type="submit" class="btn btn-primary" onclick="buttonA_clickHandler(event)">Edit</button>
                                </div>
                            </div>
                            <div class="col-lg-11">
                <div class="row mx-auto">
                    
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
                                                            <input class="form-check-input" type="checkbox" value="${product.getID()}"
                                                                   id="defaultCheck1" name="selectedEdit">
                                                    </td>
                                                    <td>
                                                        <div class="form-check">
                                                            <!--<input class="form-check-input" type="checkbox" value="${product.getID()}"
                                                                   id="defaultCheck1" name="selectedProduct">-->
                                                            <button type="submit" class="btn btn-primary" name="selectedProduct"
                                                                    value="${product.getID()}" onclick="buttonB_clickHandler(event)">Go To Product</button>
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

            </div>










        </div>





        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


    </body>

</html>