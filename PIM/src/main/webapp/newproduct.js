var i = 1; 


function createInputBox ()  {
    i++; 
    var li = document.createElement("li"); 
    var br = document.createElement("br");
    var div2 = document.createElement("div");
    div2.setAttribute("class", "invisible");

    var div = document.querySelector('.variables') ; 
    var varInputBox = document.createElement("input"); 
    var enumInputBox = document.createElement("input"); 
    var select = mySelect.value; 
    
    
    
    var hiddenInputBox = varInputBox.cloneNode(true);  
    hiddenInputBox.setAttribute("name", "type"); 
    hiddenInputBox.setAttribute("type", "hidden"); 
    hiddenInputBox.setAttribute("value", select); 
    hiddenInputBox.setAttribute("id", "variabel"+i);
    hiddenInputBox.setAttribute("readonly", true); 

    varInputBox.setAttribute("name", "attributes");
    varInputBox.setAttribute("type", "text"); 
    varInputBox.setAttribute("placeholder", select); 
    varInputBox.setAttribute("id", "variabel"+i); 
    varInputBox.required = true; 

    enumInputBox.setAttribute("name", "enumAttributes")
    enumInputBox.setAttribute("type", "text"); 
    enumInputBox.setAttribute("placeholder", "type in your enums values"); 
    enumInputBox.setAttribute("id", "variabel"+i); 
    enumInputBox.required = true; 
    

if (mySelect.value == "Enum") {
    div.append(hiddenInputBox,"     ", varInputBox,"      ", enumInputBox, br, br); 
} else {
    div.append( hiddenInputBox,"    ", varInputBox, br, br, div2);
}

    
}
