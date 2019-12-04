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
import persistence.FormGenerator;
import persistence.ProductMapper;

/**
 *
 * @author jonat
 */
public class generateFilterCommand extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "";
        String formToGenerate = request.getParameter("productType");
        String search = request.getParameter("searchItem");
        
        FormGenerator fg = new FormGenerator();
        //ArrayList<HashMap<String, Object>> forms = fg.generateForm(formToGenerate);
        ArrayList<Form> forms =  fg.generateForm(formToGenerate);
        request.setAttribute("forms", forms);

        //Send table names in order to dynamically generate dropdown boxes, if user wants to change product type
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tables = pMapper.getTableNames();

        ArrayList<Product> productType = pMapper.showProducts(formToGenerate);
        ArrayList<String> attributes = new ArrayList<>();
        

        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("tables", attributes);

        request.setAttribute("getProductType", productType);
        System.out.println("48"+productType.get(0).getName().toString());

        webpage = "SearchAndFilter";
        return webpage;
    }

}

