/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

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
public class gotoInsertProduct extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, ClassNotFoundException{
        
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tables = pMapper.getTableNames("test");
        ArrayList<String> attributes = new ArrayList<>();
        
        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("tables", attributes);
        String webpage = "InsertProduct";
        return webpage;
    }
}
