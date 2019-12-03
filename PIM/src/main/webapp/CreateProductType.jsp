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


                




                <body>
                    
                        <form action="FrontController">
                <div class="row mx-auto">
                    <h1>Create new product type</h1>
                </div>
                        <P>

                                <input type ="text" name = "productType" placeholder="Skriv hvilken produkt type du vil lave"  id = "1"> 
                        </P>
                        <div class= "book-list" id="book-list">
                        <h2 class="title">Produkt variabler</h2>
                          <p> vaelg hvilken  variabel type du skal bruge og tryk OK!</p>  

                        <select name ="myselect" id="mySelect">                                
                          <option value="String">String</option>
                          <option value="Integer">Integer</option>
                          <option value="Float">Float</option>
                          <option value="Enum">Enum</option>
                        </select>
                        <button type="button" name= "createInputBtn" id= "createInputBtn"  onclick = " createInputBox()" > Generer nyt felt </button>
                        
                    </div>

                    <div class = " bunden" id = "bottomm">
                        <p></p>
                        <p>  Afslut her</p>

                            <input type="text" name="hej" value="0" />
                                <input type="submit" class="btn btn-danger" value="Create Product">
                                <input  type="hidden" name="cmd" value="CreateProductType">
                           
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

        <script src="newproduct.js"></script>
        
        
     


    </body>

</html>