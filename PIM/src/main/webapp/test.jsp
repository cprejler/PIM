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
        <title>BootStrap test</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body>

        <!-- NAVBAR -->
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
                            <a class="dropdown-item" href="#">Search Items</a>
                            <a class="dropdown-item" href="#">Export Data</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>

                </ul>

                </form>
            </div>
        </nav>

        <div class="container-fluid" id="page-wrapper">
            <!-- Filter box -->
            <div class="container" id="filter">
                <div class="row">
                    <div class="col-lg-12" id="activeFilter">
                        <form action="Frontcontroller">

                            <h3>Filter by category</h3>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <input type="hidden" name="cmd" value="type in the form of  the columindex array  it came from">
                                <label class="form-check-label" for="defaultCheck1">
                                    wineYear
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <input type="hidden" name="cmd" value="type in the form of  the columindex array  it came from">
                                <label class="form-check-label" for="defaultCheck1">
                                    wineType
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                <input type="hidden" name="cmd" value="type in the form of  the columindex array  it came from">
                                <label class="form-check-label" for="defaultCheck1">
                                    wineCountry
                                </label>
                            </div>

                            <button type="submit" class="btn btn-secondary btn-sm">Filter</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Items to show -->
            <div class="container" id="items">
                <form action="Frontcontroller">
                    <input type="hidden" name="cmd" value="editItem">
                    <div class="row" id="items">
                        <div class="col-lg-1"><div class="position-fixed"><button type="submit" class="btn btn-primary">Edit</button></div></div>
                        <div class="col-lg-11 col-xs-1">
                            <h3>All items: <c:out value="${requestScope.columnFields.size()}"/></h3>

                            <table class="table">
                                <thead>
                                    <c:forEach var="column" items="${requestScope.columnNames}">
                                    <th scope="col">${column}</th>
                                    </c:forEach> 
                                <th>Edit</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="row" items="${requestScope.columnFields}">
                                        <tr>
                                            <c:forEach var="field" end="${requestScope.columnNames.size()-1}" items="${requestScope.columnFields}">
                                                <td>${field}</td>
                                            </c:forEach>
                                            <td>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" value="${field}" id="defaultCheck1" name="selectedEdit">
                                                    
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>
            </div>





        </div>


        <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


    </body>

</html>
