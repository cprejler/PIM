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

        ArrayList<Product> wine = pMapper.showProducts("wine");
        ArrayList<Product> phones = pMapper.showProducts("phone");
        wine.get(0).getFieldsValues();

        request.setAttribute("wine", wine);
        request.setAttribute("phones", phones);
        webpage = "ShowProducts";
        return webpage;
    }
    
}
