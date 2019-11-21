<%-- 
    Document   : searchResults
    Created on : 21. nov. 2019, 09.49.42
    Author     : jenso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
        
        <table class="table">
                                    <thead>
                                        <c:forEach var="field" items="${productList.get(0).getFields()}">
                                        <th>${field}</th>
                                        </c:forEach>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="product" items="${requestScope.productList}">
                                            <tr>
                                                <c:forEach var="fieldValues" items="${product.getFieldsValues()}">
                                                    <td>${fieldValues}</td>
                                                </c:forEach>
                                                <td>
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox" value="${product}"
                                                               id="defaultCheck1" name="selectedEdit">

                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
        
    </body>
</html>
