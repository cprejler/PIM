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
        <style>
        .allProduct{
            width:90%;
            padding:20px;
            border:solid;
            overflow:auto;
        }
        .productInfo{
            vertical-align: top;
            display:inline-block;
            width:20%;
        }
        .imageBox{
            display:inline-block;
            float:left;
            width:10%;
        }
        .checksButtons{
            float:right;
        }
        p{
            text-align:left;
            color:black;
        }
        .invisible{
            opacity: 0;
            height: 5%;
        }
        .overview{
            float:right;
            width:80%;
        }
        .filter{
            float:left;
            width:20%;
        }
        </style>
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
                               </nav>
                            </form>
                            </div>
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
                            <form action="FrontController">
                    <input type="hidden" name="cmd" value="" id="hiddenId">
                    <div class="row" mx-auto>
                        <div class="col-lg-1 mx-auto">
                            <div class="px-md-5">
                                <button type="submit" class="btn btn-primary" onclick="buttonA_clickHandler(event)">Bulk Edit Products</button>
                            </div>
                        </div>
                    </div>
                    <div class="filter"></div>
                            <div class="overview" align="center">
                                <c:forEach var="product" items ="${requestScope.productList}" varStatus="count">
                                    <div class="row">
                                    <div class="allProduct" align="center">
                                        <div class="imageBox">
                                                <c:if test="${product.getImages().size() > 0 }">
                                                    <c:set var="image" value="${product.getImages().get(0)}"/>
                                                    <img class="img-thumbnail" style="max-height:83px; max-width:83px;" src="data:image/jpeg;base64,${image.getImage()}" title="${product.getID()}">
                                                </c:if>
                                        </div>
                                        <div class="productInfo">
                                        <p><b>${product.getName()}</b></p>
                                        <p>${product.getID()}</p>
                                        <p>${product.getType()}</p>
                                    </div>
                                    <div class="checksButtons">
                                         <div class="form-check">
                                              <input class="form-check-input" type="checkbox" value="${product.getID()}"
                                                    id="defaultCheck1" name="selectedEdit"></div>
                                                        <div class="form-check col">
                                                            <button type="submit" class="btn btn-primary" name="selectedProduct"
                                                                    value="${product.getID()}" onclick="buttonB_clickHandler(event)">Go To Product</button></div>
                                                        <div class="form-check col">
                                                            <button type="submit" class="btn btn-primary" name="selectedEdit"
                                                                    value="${product.getID()}" onclick="buttonA_clickHandler(event)">Edit Product</button></div>
                                    </div>
                                    </div>
                                    </div>
                                </c:forEach>
                                
                                
                            
                            
                        </li>

                    </ul>
                </div>
        </form>
                <script type="text/javascript" src="buttonFunction.js"></script>
    </body>
</html>