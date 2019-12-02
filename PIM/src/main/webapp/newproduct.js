var i = 1; 
var j = 1; 
var k = 1;  
var buttonElement = document.getElementById('createInputBtn'); 
var dropdownElement = document.getElementById('mySelect'); 
 




function createInputBox ()  {
    i++; 
  //  var buttonid = "createInputBtn"+i; 
    //var element = "buttonElement" + i; 
    var cloneButton  = buttonElement.cloneNode(true);
   // var cloneDropdown = dropdownElement.cloneNode(true); 
    //var button = cloneOK; 



   var div = document.querySelector('.book-list') ; 
   //var buttonName = document.getElementById('createInputBtn'); 
   var li = document.createElement("li"); 
   
    var x = document.createElement("input"); 
   // cloneButton.setAttribute("Id", buttonid); 
    var dropdown = dropdown+i; 
    
    
    
    x.setAttribute("name", "variabelNavn")
    x.setAttribute("type", "text"); 
    x.setAttribute("placeholder", dropdown); 

    x.setAttribute("id", "variabel"+i); 

    var y = x; 

    //div.append(li);
    //div.append(<br> </br> );  
    div.append(li, x); 
//        div.append(x);

    
    // div.append();
   //  div.createElement
    
}

function createDropDown () {
    j++;
    var div = document.querySelector('.book-list') ; 
    var cloneDropdown = dropdownElement.cloneNode(true); 
    cloneDropdown.setAttribute("id", "dropdown"+j); 

    div.append(cloneDropdown);     
}


function createOk () {
    k++; 
    var div = document.querySelector('.book-list') ; 
    var clonebuttonOK = buttonElement.cloneNode(true);
    var buttonid = "createInputBtn"+k; 


    clonebuttonOK.setAttribute("Id", buttonid); 
    

    div.append(clonebuttonOK);

}


 // function setid() {
    // var varnavne = docuement.getElementById("mySelect");  
         
 
   //      var bookList = document.querySelector('#book-list');
  //       bookList.innerHTML += '<li> <span class="name">Skriv ny produkt variabel </span> </li>';
  //       bookList.innerHTML += '<select id="mySelect"> <option value="String">String</option> <option value="Integer">Integer</option> <option value="Float">Float</option> <option value="Enum">Enum</option> </select>';
 //        bookList.innerHTML += '<input type="text" />'  ; 
  //       bookList.innerHTML += '<button onclick = "setid(), e(e)" > click me!  </button>'; 
     
         

 //}