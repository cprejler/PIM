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
        <title>Update Product</title>
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

                <c:forEach var="product" items="${products}"  varStatus="productCounter">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div><h1 class="text-primary">ProductID: ${product.getID()}</h1></div>
                            </div>
                        </div>


                        <div class="row">


                            <div class="col-lg-6 mg-2">

                                <div>
                                    <h5 class="text-primary">Manufacturer</h5>
                                    <input type="text" name="manufacturer" value="${product.getManufacturer()}" readonly>
                                </div>
                                <div>
                                    <h5 class="text-primary">Product Name</h5>
                                    <input type="text" name="productName" value="${product.getName()}"  readonly>
                                </div>
                                <div>
                                    <h5 class="text-primary">Product Type</h5>
                                    <input type="text" name="productType" value="${product.getType()}"  readonly>
                                </div>
                                <c:forEach var="field" items="${product.getFields()}" varStatus="fieldCounter">
                                    <h5 class="text-primary">${field}</h5>
                                    <input type="text" name="${field}" value="${product.getFieldsValues().get(fieldCounter.index)}" readonly>
                                </c:forEach>


                            </div>




                            <div  class="col-lg-6 mg-2">
                                <form action="FrontController">

                                    <h5 class="text-primary">Manufacturer</h5>
                                    <input type="text" class="form-control" name="manufacturer"  value="${product.getManufacturer()}">
                                    <h5 class="text-primary">Product Name</h5>
                                    <input type="text" class="form-control" name="productName" value="${product.getName()}">
                                    <h5 class="text-primary">Product Type</h5>
                                    <input type="text" name="productType" value="${product.getType()}" readonly>


                                    
                                    <c:forEach var="form"  items="${forms.get(productCounter.index)}">
                                        <h5 class="text-primary">${form.getName()}</h5>

                                        <c:if  test="${form.getInputType() eq 'select'}">
                                            <select name="${form.getName()}">
                                                <c:forEach var="item" items="${form.getOptions()}">
                                                    <option>${item}</option>
                                                </c:forEach>

                                            </select>
                                        </c:if>
                                        <c:if  test="${form.getInputType() ne 'select'}">
                                            <input type="${form.getInputType()}" name="${form.getName()}" value="${field}">
                                        </c:if>

                                    </c:forEach>

                                    <input type="submit" class="btn btn-primary" value="Apply Changes">
                                    <input  type="hidden" name="productID" value="${product.getID()}">
                                    <input  type="hidden" name="cmd" value="UpdateProduct">
                                </form>


                            </div>


                        </div>






                    </div>






                    <br>
                </c:forEach>






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