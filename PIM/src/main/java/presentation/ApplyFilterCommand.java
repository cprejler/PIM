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
 * @author casper
 */
public class ApplyFilterCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "";
        ProductMapper pMapper = new ProductMapper();
        String productType = request.getParameter("");
        String field = request.getParameter("field");
        String fieldValue = request.getParameter("fieldValue");
        
        ArrayList<Product> filteredProducts = pMapper.filteredProducts(productType, field, fieldValue);
        
        request.setAttribute("filteredProducts", filteredProducts);
        
        return webpage;
        
    }
    
}
