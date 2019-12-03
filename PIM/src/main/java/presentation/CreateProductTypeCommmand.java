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
        String webpage = "";
        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        ArrayList<String> enumValues = new ArrayList<>();
        String productType = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        //Enumeration<String> parameterNeames = request.get();
        ArrayList<String> params = new ArrayList<>();
        
        ArrayList<String> requestParameters  = new  ArrayList<>();
        
        while (parameterNames.hasMoreElements()) {
            params.add(parameterNames.nextElement());
        }
        
        for (String param : params) {
            StringBuilder sb = new StringBuilder(param.toLowerCase());
            switch (sb.charAt(0)) {
                case 's':
                    type.add("string");
                    break;
                case 'i':
                    type.add("integer");
                    break;
                case 'e':
                    type.add("enum");
                    break;
                case 'f':
                    type.add("float");
                    break;
                default:
                    break;
            }
             
        }
    //Get  the actual value   of  the  parameters, as well  as add the names to the fields array
        //We  don't  want  manufacturer, productName, and  productType  added to that array
        for (String param : params) {
                requestParameters.add(request.getParameter(param));
            }
        for (String requestParameter : requestParameters) {
                if(requestParameter.contains("enum")) {               
                enumValues.add(requestParameter);
                }else if(requestParameter.contains("produtType")){
                    productType=requestParameter;
                } 
                else{
                    columnNames.add(requestParameter);
                }
            }
        
    //pMapper.createProductTable (params, type, enumValues, productType);
    return webpage ;
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

