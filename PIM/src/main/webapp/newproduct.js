var i = 1; 
var j = 1; 
var k = 1;  
var buttonElement = document.getElementById('createInputBtn'); 
var dropdownElement = document.getElementById('mySelect'); 

 
function ifEnum () {
    dropdownElement.addEventListener("click");

    var div = document.querySelector('.book-list') ; 
    var enums = document.createElement("input"); 

    enums.setAttribute("name", "enums"+i)
    enums.setAttribute("type", "text"); 
    enums.setAttribute("placeholder", "skriv dine enums, comma separeret "); 

    enums.setAttribute("id", "enums"+i); 

 



}



function createInputBox ()  {
    i++; 
    var li = document.createElement("li"); 
    var br = document.createElement("br");

    var cloneButton  = buttonElement.cloneNode(true);

    var div = document.querySelector('.book-list') ; 
   
    var x = document.createElement("input"); 
    var dropdown = dropdown+i; 
    var enums = document.createElement("input"); 
    
    var select = mySelect.value; 
    
    var y = x.cloneNode(true);  
    y.setAttribute("name", "type"); 
    y.setAttribute("type", "text"); 
    y.setAttribute("value", select); 
    y.setAttribute("id", "variabel"+i);
    y.setAttribute("readonly", true); 
    


    x.setAttribute("name", "attributes");
    x.setAttribute("type", "text"); 
    x.setAttribute("placeholder", select); 
    x.setAttribute("id", "variabel"+i); 



    enums.setAttribute("name", "enumAttributes")
    enums.setAttribute("type", "text"); 
    enums.setAttribute("placeholder", "Skriv enumværdierne sepereret af comma"); 
    enums.setAttribute("id", "variabel"+i); 

if (mySelect.value == "Enum") {
    div.append(y,"     ", x,"      ", enums, br); 
} else {
    div.append(y,"    ", x, br); 
}
    
 
 

    
}

function createDropDown () {
    var li = document.createElement("li"); 
    var br = document.createElement("br");
    j++;
    var div = document.querySelector('.book-list') ; 
    var cloneDropdown = dropdownElement.cloneNode(true); 
    cloneDropdown.setAttribute("id", "dropdown"+j); 

    cloneDropdown.setAttribute("onchange", "changefunction(this.value)"); 



    document.getElementById("dropdown"+j);

    div.append(cloneDropdown);     
}

function changefunction(val) {
if (val == "Enum") {


    createInputBox (); 

    

}


}


function createOk () {
    var li = document.createElement("li"); 
    var br = document.createElement("br");

    k++; 
    var div = document.querySelector('.book-list') ; 
    var clonebuttonOK = buttonElement.cloneNode(true);
    var buttonid = "createInputBtn"+k; 


    clonebuttonOK.setAttribute("Id", buttonid); 
    

    div.append(clonebuttonOK, br);

}


 // function setid() {
    // var varnavne = docuement.getElementById("mySelect");  
         
 
   //      var bookList = document.querySelector('#book-list');
  //       bookList.innerHTML += '<li> <span class="name">Skriv ny produkt variabel </span> </li>';
  //       bookList.innerHTML += '<select id="mySelect"> <option value="String">String</option> <option value="Integer">Integer</option> <option value="Float">Float</option> <option value="Enum">Enum</option> </select>';
 //        bookList.innerHTML += '<input type="text" />'  ; 
  //       bookList.innerHTML += '<button onclick = "setid(), e(e)" > click me!  </button>'; 
     
         

 //}