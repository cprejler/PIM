var i = 1; 
var buttonElement = document.getElementById('createInputBtn'); 


function createInputBox ()  {
    i++; 
    var li = document.createElement("li"); 
    var br = document.createElement("br");

    var cloneButton  = buttonElement.cloneNode(true);

    var div = document.querySelector('.book-list') ; 
   
    var columnInputBox = document.createElement("input"); 
    var dropdown = dropdown+i; 
    var enumInputBox = document.createElement("input"); 
    
    var select = mySelect.value; 
    
    var ColumnTypeInputBox = columnInputBox.cloneNode(true);  
    ColumnTypeInputBox.setAttribute("name", "type"); 
    ColumnTypeInputBox.setAttribute("type", "hidden"); 
    ColumnTypeInputBox.setAttribute("value", select); 
    ColumnTypeInputBox.setAttribute("id", "variabel"+i);
    ColumnTypeInputBox.setAttribute("readonly", true); 
    


    columnInputBox.setAttribute("name", "attributes");
    columnInputBox.setAttribute("type", "text"); 
    columnInputBox.setAttribute("placeholder", select); 
    columnInputBox.setAttribute("id", "variabel"+i); 



    enumInputBox.setAttribute("name", "enumAttributes")
    enumInputBox.setAttribute("type", "text"); 
    enumInputBox.setAttribute("placeholder", "type in your enums values"); 
    enumInputBox.setAttribute("id", "variabel"+i); 

if (mySelect.value == "Enum") {
    div.append(ColumnTypeInputBox,"     ", columnInputBox,"      ", enumInputBox, br); 
} else {
    div.append(ColumnTypeInputBox,"    ", columnInputBox, br); 
}
}



