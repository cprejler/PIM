/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FormGenerator;
import persistence.ProductMapper;

/**
 *
 * @author casper
 */
public class generateFormCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "";
        String formToGenerate = request.getParameter("productType");
        FormGenerator fg = new FormGenerator();
        //ArrayList<HashMap<String, Object>> forms = fg.generateForm(formToGenerate);
        ArrayList<Form> forms =  fg.generateForm(formToGenerate);
        request.setAttribute("forms", forms);
        
        //Send table names in order to dynamically generate dropdown boxes, if user wants to change product type
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tables = pMapper.getTableNames();
        ArrayList<String> attributes = new ArrayList<>();
        
        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("tables", attributes);
        
        
        webpage = "InsertProductType";
        return webpage;
    }

}
