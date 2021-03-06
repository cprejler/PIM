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
        
        <div class="container-fluid" id="page-wrapper">
            <div class="container">

                <c:forEach var="product" items="${products}"  varStatus="productCounter">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6">
                                <div><h1 class="text-primary">ProductID: ${product.getID()}</h1></div>
                                <h4 class="text-primary">Upload an image</h4>
                                <!-- IMAGE UPLOAD -->
                                <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
                                    <input type="file" name="image" accept="image/png, image/jpeg">


                                    <input type="hidden" name="productID" value="${product.getID()}">

                                    <input type="submit" class="btn btn-primary" value="Upload">

                                </form>



                            </div>
                        </div>
                        <div class="row">
                            <c:forEach var="image" items="${product.getImages()}">
                                <div>
                                    <img class="img-thumbnail" style="max-height:200px; max-width: 200px;" src="data:image/jpeg;base64,${image.getImage()}" title="${product.getID()}">
                                </div>
                            </c:forEach>
                        </div>

                        <!-- READ ONLY FIELDS -->
                        <div class="row">


                            <div class="col-lg-6 mg-2">

                                <div>
                                    <h5 class="text-primary">Manufacturer</h5>
                                    <input type="text" name="manufacturer" value="${product.getManufacturer()}" style="color:grey" readonly>
                                </div>
                                <div>
                                    <h5 class="text-primary">Product Name</h5>
                                    <input type="text" name="productName" value="${product.getName()}" style="color:grey" readonly>
                                </div>
                                <div>
                                    <h5 class="text-primary">Description</h5>
                                    <textarea type="text" name="description" cols="40" rows="5" maxlength="500" style="color:grey" readonly> ${product.getDescription()}</textarea>
                                </div>
                                <div>
                                    <h5 class="text-primary">Product Type</h5>
                                    <input type="text" name="productType" value="${product.getType()}" style="color:grey"  readonly>
                                </div>
                                <c:forEach var="field" items="${product.getFields()}" varStatus="fieldCounter">
                                    <h5 class="text-primary">${field}</h5>
                                    <input type="text" name="${field}" style="color:grey" value="${product.getFieldsValues().get(fieldCounter.index)}" readonly>
                                </c:forEach>


                            </div>


                            <!-- FIELDS YOU CAN EDIT -->

                            <div  class="col-lg-6 mg-2">
                                <form action="FrontController">
                                    <div>
                                        <h5 class="text-primary">Manufacturer</h5>
                                        <input type="text" name="manufacturer" maxlength="45" value="${product.getManufacturer()}" required>
                                    </div>
                                    <div>
                                        <h5 class="text-primary">Product Name</h5>
                                        <input type="text" name="productName" maxlength="45" value="${product.getName()}"required>
                                    </div>
                                    <div>
                                        <h5 class="text-primary">Description</h5>       
                                        <textarea type="text" name="description" required cols="40" rows="5" maxlength="500"> ${product.getDescription()}</textarea>
                                    </div>
                                    <div>
                                        <h5 class="text-primary">Product Type</h5>
                                        <input type="text" name="productType" value="${product.getType()}" readonly>
                                    </div>
                                    <c:forEach var="field" items="${product.getFields()}" varStatus="fieldCounter">
                                        <h5 class="text-primary">${field}</h5>
                                        <input type="text" name="${field}" value="${product.getFieldsValues().get(fieldCounter.index)}" required>
                                    </c:forEach>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <input type="submit" class="btn btn-primary p-t-3" value="Apply Changes">
                                            <input  type="hidden" name="productID" value="${product.getID()}">
                                            <input  type="hidden" name="cmd" value="UpdateProduct">
                                            </form>
                                        </div>
                                        <div class="col-lg-6">
                                            <form action="FrontController">
                                                <input type="submit" class="btn btn-danger p-t-3" value="Delete Product">
                                                <input  type="hidden" name="productID" value="${product.getID()}">
                                                <input  type="hidden" name="cmd" value="DeleteProduct">
                                            </form>
                                        </div>
                                    </div>

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