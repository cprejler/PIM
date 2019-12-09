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
 * @author jenso
 */
public class SearchProductCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        String searchItem = request.getParameter("searchItem");
        
        ProductMapper pm = new ProductMapper();
        
        ArrayList<Product> products = pm.searchForProduct(searchItem);
        ArrayList<String> tables = pm.getTableNames();
        ArrayList<String> attributes = new ArrayList<>();
        
        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("productList", products);
        request.setAttribute("tables", attributes);
        request.setAttribute("searchItem", searchItem);
        return "SearchResults2";
    }
    
}
