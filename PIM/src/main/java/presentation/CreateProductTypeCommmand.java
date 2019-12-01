/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

/**
 *
 * @author Malthorn
 */
public class CreateProductTypeCommmand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        ProductMapper pMapper = new ProductMapper();
        
        ArrayList<String> columnNames = new ArrayList<>(); 
        ArrayList<String> EnumValues = new ArrayList<>();
        
        
        Enumeration<String> parameterNames = request.getParameterNames();
        ArrayList<String>params  = new ArrayList<>();
        
                while(parameterNames.hasMoreElements()){
            params.add(parameterNames.nextElement());
        }
                
        ArrayList<String> requestParameters  = new  ArrayList<>();
        
        
        for (String param : params) {
            
            if (!param.equals("manufacturer") && !param.equals("productName") && !param.equals("productType") &&  !param.equals("cmd")){
                columnNames.add(param);
                requestParameters.add(request.getParameter(param));
            }
                       
        }
        return null;
    }
}
    

        
        
        
        
        
        
//        
//        
//        for (String table : tables) {
//            attributes.add(table);
//        }
//        request.setAttribute("tables", attributes);
//        String webpage = "InsertProduct";
//        return webpage;
//        
//        
//    }
    

