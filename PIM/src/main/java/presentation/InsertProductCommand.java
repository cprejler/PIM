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
public class InsertProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, ClassNotFoundException{
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String manufacturer = request.getParameter("manufacturer");
        String[] getfields = request.getParameterValues("");

        

        
        //Fra gamle prjekt, Vi burde måske lave en lignende metode
        //Boolean usernameDB = db.checkUsername(username);
        ProductMapper pM = new ProductMapper();
        String webpage = "";
        //pM.insertProduct(product);
        webpage="Confirmation";
        return webpage;
//        
    } 
}
