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
        <link rel = "stylesheet" type = "text/css" href = "ProductView.css" />
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
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
                            <form action="FrontController">
                                <button type="submit" class="dropdown-item" name="cmd" value="gotoInsertProduct">Insert
                                    Product</button>
                                <button type="submit" class="dropdown-item" name="cmd" value="ShowProducts">Show
                                    Products</button>
                                <button type="submit" class="dropdown-item" name="cmd" value="gotoCreateProductType">Create Product Type</button>
                            </form>     
                            <div class="dropdown-divider"></div>
                            <form action="FileDownloadServlet">

                                <button type="submit" class="dropdown-item" name="cmd" value="exportExcel">Export
                            </form>
                        </div>
                    </li>

                </ul>

            </div>

            <div class="row mx-auto px-md-5">
                <div class="col">

                    <div class="search-bar">
                        <form action="FrontController">

                            <input type="text" name="searchItem" placeholder="Search productname/id">
                            <input type="hidden" name="cmd" value="search">
                            <input type="submit" name="button" value="Search">

                        </form>
                    </div>
                </div>
            </div>
        </nav>

        
        <div class="filter">
            
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
            <div class="productView" align="center">
                <div class="searchFound">
                    <p>${requestScope.productList.size()} result(s) found for searched value: ${requestScope.searchItem}</p>
                    <c:if test="${requestScope.productList.size() < 1}">
                        <p>Did you search for a name or ID?</p>
                    </c:if>
                </div>
                <c:forEach var="product" items ="${requestScope.productList}" varStatus="count">
                    <div class="row">
                        <div class="allProduct" align="center" style="margin:10px">
                            <div class="imageBox">
                                <c:if test="${product.getImages().size() > 0 }">
                                    <c:set var="image" value="${product.getImages().get(0)}"/>
                                    <img class="img-thumbnail" style="max-height:100px; max-width:100px;" src="data:image/jpeg;base64,${image.getImage()}" title="${product.getID()}">
                                </c:if>
                                <c:if test="${product.getImages().size() < 1}">
                                    <img src="Udklip.PNG" style="max-height:100px; max-width:100;">
                                </c:if>
                            </div>
                            <div class="productInfo">
                                <p><b>${product.getName()}</b></p>
                                <p>ProductID: ${product.getID()}</p>
                                <p>${product.getType()}</p>
                            </div>
                            <div class="description">
                                <p>${product.getDescription()}</p> 
                            </div>
                            <div class="checkBoxBox">
                                <div class="form-check">
                                    <p>Edit</p>

                                    <input class="form-check-input" type="checkbox" value="${product.getID()}"
                                           id="defaultCheck1" name="selectedEdit"></div>
                            </div>
                            <div class="checksButtons">
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

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="buttonFunction.js"></script>

    </body>
</html>