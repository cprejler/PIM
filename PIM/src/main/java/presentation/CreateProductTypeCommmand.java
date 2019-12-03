/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
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
        ArrayList<String> productTypeArray = new ArrayList<>();
        String productType = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        //Enumeration<String> parameterNeames = request.get();
        ArrayList<String> params = new ArrayList<>();
        Map<String, String[]> parametermap = request.getParameterMap();
        for (String key : parametermap.keySet()) {
            if (key.equalsIgnoreCase("attributes")) {
                columnNames = new ArrayList<>(Arrays.asList(parametermap.get(key)));
            } else if(key.equalsIgnoreCase("enumAttributes")){
                enumValues = new ArrayList<>(Arrays.asList(parametermap.get(key)));
            } else if(key.equalsIgnoreCase("type")){
                type = new ArrayList<>(Arrays.asList(parametermap.get(key)));
            } else if(key.equalsIgnoreCase("productType")){
                productTypeArray = new ArrayList<>(Arrays.asList(parametermap.get(key)));
                productType = productTypeArray.get(0).toString();
        }
        }

//        ArrayList<String> requestParameters = new ArrayList<>();

//        while (parameterNames.hasMoreElements()) {
//            params.add(parameterNames.nextElement());
//        }

//        for (String typer : type) {
//            String sb = typer.toLowerCase();
//            switch (sb.charAt(0)) {
//                case 's':
//                    type.add("string");
//                    break;
//                case 'i':
//                    type.add("integer");
//                    break;
//                case 'e':
//                    type.add("enum");
//                    break;
//                case 'f':
//                    type.add("float");
//                    break;
//                default:
//                    break;
//            }
//        }
//        for (String param : params) {
//            requestParameters.add(request.getParameter(param));
//            if ((param.contains("enum"))) {
//                enumValues.add(request.getParameter(param));
//            } else if (param.contains("productType")) {
//                productType = (request.getParameter(param));
//            } else {
//                columnNames.add(request.getParameter(param));
//            }
//        }
//        for (String requestParameter : requestParameters) {
//                if(requestParameter.contains("enum")) {               
//                enumValues.add(requestParameter);
//                }else if(requestParameter.contains("produtType")){
//                    productType=requestParameter;
//                } 
//                else{
//                    columnNames.add(requestParameter);
//                }
//            }

        ArrayList<String> generateproducts = new ArrayList();

        generateproducts.add(productType);

        for (int i = 0; i < type.size(); i++) {
            String productsss = "";
            char c = type.get(i).charAt(0); 
            productsss = ""+c+"";
            StringBuilder sb = new StringBuilder(productsss);

            productsss += sb.substring(1) + columnNames.get(i).toString();
            generateproducts.add(productsss);

        }
        
        pMapper.createProductTable(generateproducts, enumValues);
        return "ShowProducts";
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

