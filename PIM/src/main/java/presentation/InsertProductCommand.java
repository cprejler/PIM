package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

public class InsertProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, ClassNotFoundException{
        
        
        ArrayList<String> fields = new ArrayList<>(); //Represents the columnHeaders in the database
        ArrayList<Object> fieldValues = new ArrayList<>(); //Represents the row values 
        Enumeration<String> parameterNames = request.getParameterNames(); // Since forms are always dynamically made from the database based on the product type selected, we need to get the names
        ArrayList<String>params  = new ArrayList<>();
        
        //Get the names of  the  Parameters in  order to make request.getParameter() on them after to get the  actual  value
        while(parameterNames.hasMoreElements()){
            params.add(parameterNames.nextElement());
        }
        
        ArrayList<String> requestParameters  = new  ArrayList<>();
        //Get  the actual value   of  the  parameters, as well  as add the names to the fields array
        //We  don't  want  manufacturer, productName, and  productType, cmd and description  added to that array
        for (String param : params) {
            
            if (!param.equals("manufacturer") && !param.equals("productName") && !param.equals("productType") &&  !param.equals("cmd") &&!param.equals("description")){
                fields.add(param);
                requestParameters.add(request.getParameter(param));
            }
                       
        }
        
        //Manufacturer, productName, productType, description will  always  be the first 4
        
        String manufacturer = request.getParameter("manufacturer");

        String productName = request.getParameter("productName");
        String productType = request.getParameter("productType");
        String description = request.getParameter("description");
        
       

        for (String requestParameter : requestParameters) {
            if (!requestParameter.equals("manufacturer") && !requestParameter.equals("productName") && !requestParameter.equals("productType")&&!requestParameter.equals("cmd") && !requestParameter.equals("description")) {
                                
                fieldValues.add(requestParameter);
            }

        }
        

        
        Product product = new Product(productName, productType, manufacturer, fields, fieldValues);
        product.setDescription(description);

        ProductMapper pMapper = new ProductMapper();

        try {
            pMapper.insertProduct(product);
        } catch (SQLException e) {
            
            request.setAttribute("error", e.getMessage());
            request.setAttribute("cause", e.getCause());
            request.setAttribute("stacktrace", e.getStackTrace());
           
            
        }
        
        
        
        return returnToShowProducts(request, response);
    } 
}
