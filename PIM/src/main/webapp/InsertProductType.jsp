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
        <title>Insert product</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body>

        <!-- NAVBAR -->
        <form action="Frontcontroller">

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
                                <button type="submit" class="dropdown-item" name="cmd" value="searchItems">Search
                                    Items</button>
                                <button type="submit" class="dropdown-item" name="cmd" value="insertProduct">Insert
                                    Product</button>
                                <button type="submit" class="dropdown-item" name="cmd" value="updateProduct">Update
                                    Product</button>

                                <div class="dropdown-divider"></div>
                                <button type="submit" class="dropdown-item" name="cmd" value="searchItems">Export
                                    Data</button>

                            </div>
                        </li>

                    </ul>


                </div>
            </nav>
        </form>
        <div class="container-fluid" id="page-wrapper">
            <div class="container">
                <h1 class="text-primary">Insert product</h1>
                <h3 class="text-primary">Type of product to insert</h3>
                <form action="FrontController">
                    <select class="form-control  m-2" name="productType">
                        <%-- Inputs are  made for each productType in database --%>
                        <option value="wine">wine</option>
                        <option value="phone">phone</option>
                    </select>
                    <input type="submit" value="Select" class="btn btn-primary m-2">
                    <input type="hidden"  name="cmd" value="generateForm">

                </form>

            </div>

            <div class="container">
                <form action="FrontController">

                    <h5 class="text-primary">Manufacturer</h5>
                    <input type="text" class="form-control" name="manufacturer">
                    <h5 class="text-primary">Product Name</h5>
                    <input type="text" class="form-control" name="productName">
                    <h5 class="text-primary">Product Type</h5>
                    <input type="text" name="productType" value="${param.productType}" readonly>
                    


                    <c:forEach var="form"  items="${requestScope.forms}">
                        <h5 class="text-primary">${form.get("name")}</h5>

                        <c:if  test="${form['inputType'] == 'select'}">
                            <select name="${form.get("name")}">
                                <c:forEach var="item" items="${form['options']}">
                                    <option>${item}</option>
                                </c:forEach>

                            </select>
                        </c:if>
                        <c:if  test="${form['inputType'] != 'select'}">
                            <input type="${form.get("inputType")}" name="${form.get("name")}">
                        </c:if>

                    </c:forEach>
                    <input type="submit" class="btn btn-primary" value="Insert Product">
                    <input  type="hidden" name="cmd" value="insertProduct">
                </form>

            </div>
        </div>



    </body>

</html>