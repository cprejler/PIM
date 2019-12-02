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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

/**
 *
 * @author jonat
 */
public class ShowSpecificProductCommand extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
    
        String webpage = "ShowSpecificProduct";
        ProductMapper pMapper = new ProductMapper();
        
        ArrayList<String> tableNames = pMapper.getTableNames();
        
        ArrayList<ArrayList<Product>> products = new ArrayList();
        
        for (String tableName : tableNames) {
            ArrayList<Product> productType   = pMapper.showProducts(tableName);
            products.add(productType);
            
            
            
        }
        
        
        
        request.setAttribute("tableNames", tableNames);
        request.setAttribute("products", products);
        
                      
              
        return webpage;

    
    }
}