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
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

/**
 *
 * @author jonat
 */
public class UpdateProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, ClassNotFoundException{
        String webpage  = "";
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<Object> fieldValues = new ArrayList<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        ArrayList<String>params  = new ArrayList<>();
        
        //Get the names of  the  Parameters in  order to make request.getParameter() on them after to get the  actual  value
        while(parameterNames.hasMoreElements()){
            params.add(parameterNames.nextElement());
        }
        
        ArrayList<String> requestParameters  = new  ArrayList<>();
        //Get  the actual value   of  the  parameters, as well  as add the names to the fields array
        //We  don't  want  manufacturer, productName, and  productType  added to that array
        for (String param : params) {
            
            if (!param.equals("manufacturer") && !param.equals("productName") && !param.equals("productType") &&  !param.equals("cmd")){
                fields.add(param);
                requestParameters.add(request.getParameter(param));
            }
                       
        }
        
        //Manufacturer, productName, productType, will  always  be the first 3
        
        String manufacturer = request.getParameter("manufacturer");
        String productName = request.getParameter("productName");
        String productType = request.getParameter("productType");
        String description = request.getParameter("description");
        
       

        for (String requestParameter : requestParameters) {
            if (!requestParameter.equals("manufacturer") && !requestParameter.equals("productName") && !requestParameter.equals("productType")&&!requestParameter.equals("cmd") && !requestParameter.equals("description")); {
                                
                fieldValues.add(requestParameter);
            }

        }
        
        
        Product product = new Product(productName, productType, manufacturer, fields, fieldValues);
        product.setDescription(description);
        product.setID(Integer.parseInt(request.getParameter("productID")));
        product.setPublished(Boolean.FALSE);

        ProductMapper pMapper = new ProductMapper();
        ArrayList<Product> productList = new  ArrayList<>();
        productList.add(product);

        try {
            pMapper.updateProduct(productList);
            
            
        } catch (SQLException e) {
            
            request.setAttribute("error", e.getMessage());
            request.setAttribute("cause", e.getCause());
            request.setAttribute("stacktrace", e.getStackTrace());
            webpage="Error";
           
            
        }

        webpage="ShowProducts_1";
        return returnToShowProducts(request, response) ; 
       // return webpage;
    }
    }
