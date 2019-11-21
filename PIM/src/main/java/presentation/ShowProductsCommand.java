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
public class ShowProductsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        String webpage = "ShowProducts";
        ProductMapper pMapper = new ProductMapper();
        
        ArrayList<String> tableNames = pMapper.getTableNames("test");
        
        
        for (String tableName : tableNames) {
            ArrayList<Product> products   = pMapper.showProducts(tableName);
            request.setAttribute(tableName, products);
            
        }
        ArrayList<Product> wine = pMapper.showProducts("wine");
        request.setAttribute("wine", wine);
              
        return webpage;
    }
    
}
