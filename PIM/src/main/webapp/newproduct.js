var i = 1; 
var j = 1; 
var k = 1;  
var buttonElement = document.getElementById('createInputBtn'); 
var dropdownElement = document.getElementById('mySelect'); 

 
function ifEnum () {
    dropdownElement.addEventListener("click")

    var div = document.querySelector('.book-list') ; 
    var enums = document.createElement("input"); 

    enums.setAttribute("name", "enums"+i)
    enums.setAttribute("type", "text"); 
    enums.setAttribute("placeholder", "Write your enums, seperatet with a comma "); 

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
    
    x.setAttribute("name", select+i)
    x.setAttribute("type", "text"); 
    x.setAttribute("placeholder", select); 
    x.setAttribute("id", "variabel"+i); 



    enums.setAttribute("name", "value"+i)
    enums.setAttribute("type", "text"); 
    enums.setAttribute("placeholder", "Write your enums, seperatet with a comma "); 
    enums.setAttribute("id", "variabel"+i); 

if (mySelect.value == "Enum") {
    div.append(x,"      ", enums, br); 
} else {
    div.append(x, br); 
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


