/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FormGenerator;
import persistence.ProductMapper;

/**
 *
 * @author jonat
 */
public class gotoUpdateProduct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException, SQLException, ClassNotFoundException {
        ProductMapper  pMapper =  new ProductMapper();
        String[] parameters = request.getParameterValues("selectedEdit");
        ArrayList<Product> products  =  new ArrayList<>();
        ArrayList<ArrayList<Form>> forms  = new ArrayList<>();
        FormGenerator fg = new FormGenerator();
        
        for (String parameter : parameters) {
            //Get  value of the productID for each parameter
            Integer  id = Integer.parseInt(parameter);
            //Call method to create a product from  the productID
            Product product = pMapper.getProduct(id);
            //Put all  the products in a array
            products.add(product);
            //Create  the form for  the  current productType
            
            
            forms.add(fg.generateForm(product.getType()));
            
        }
        
        
        
        
        
        request.getSession().setAttribute("forms", forms);
            
                
        //Forward the  array as attribute
        
        
        request.getSession().setAttribute("products", products);
        
        
       
        
        
        String webpage = "UpdateProduct";
        return webpage;
    }
    
}
