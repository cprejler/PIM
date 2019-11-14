/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

/**
 *
 * @author jonat
 */
public class DeleteProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, ClassNotFoundException{
        String productId = request.getParameter("ID");
        
        String sqlStatement = "SELECT * from product WHERE productID='"+productId+"'";
        Statement getColumnNames = connection.createStatement();
        Statement statement = connection.createStatement();
        ResultSet rs = getColumnNames.executeQuery(sqlStatement);
        ResultSet result = statement.executeQuery(sqlStatement); 
        
        ArrayList fields = null;
        
        
       // Product product = new Product(fields, name, category, type, manufacturer);
        
        //Fra gamle prjekt, Vi burde måske lave en lignende metode
        //Boolean usernameDB = db.checkUsername(username);
        String webpage = "";
        ProductMapper pM = new ProductMapper();
        pM.deleteProduct(null);
        webpage="Confirmation";
        return webpage;
        
        
    }
    
}
