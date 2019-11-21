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
        
        String webpage = "";
        ProductMapper pMapper = new ProductMapper();
        
        ArrayList<String> tableNames = pMapper.getTableNames("test");
        ArrayList<ArrayList<Product>> products = new ArrayList();
        for (String tableName : tableNames) {
            products.add(pMapper.showProducts(tableName));
            
        }
        
        request.setAttribute("tableNames", tableNames);
        request.setAttribute("products", products);
        
        products.get(0).get(0).getFields();

        
        webpage = "ShowProducts";
        return webpage;
    }
    
}
