/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
public class gotoUpdateProduct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        String[] parameters = request.getParameterValues("selectedEdit");
        
        //Get  value of the productID for each parameter
        
        //Call method to create a product from  the productID
        
        //Put all  the products in a array
        
        //Forward the  array as attribute
        
        
        request.setAttribute("parameters", parameters);
        
        request.setAttribute("size", parameters.length);
       
        
        
        String webpage = "UpdateProduct";
        return webpage;
    }
    
}
