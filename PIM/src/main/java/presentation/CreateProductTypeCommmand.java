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
        String webpage="";
        ArrayList<String> columnNames = new ArrayList<>(); 
        ArrayList<String> enums = new ArrayList<>();
        ArrayList<String> enumValues = new ArrayList<>();
        
        Enumeration<String> parameterNames = request.getParameterNames();
        ArrayList<String>params  = new ArrayList<>();
        
                while(parameterNames.hasMoreElements()){
            params.add(parameterNames.nextElement());
        }
                
        for (String param : params) {
            if(param.contains("enum")){
               enums.add(param);
            }else if(param.contains("value")){
                enumValues.add(param);
            }
            else{
                columnNames.add(param);
            }
        }
        
        pMapper.createProductTable(params, enums, enumValues);
        return webpage;
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
    

