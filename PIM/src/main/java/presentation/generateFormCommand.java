package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FormGenerator;
import persistence.ProductMapper;

public class generateFormCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "InsertProductType";
        String formToGenerate = request.getParameter("productType");
        FormGenerator fg = new FormGenerator();
        ArrayList<Form> forms = fg.generateForm(formToGenerate);
        request.setAttribute("forms", forms);

        //Send table names in order to dynamically generate dropdown boxes, if user wants to change product type
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tables = pMapper.getTableNames();
        ArrayList<String> attributes = new ArrayList<>();

        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("tables", attributes);

        return webpage;
    }

}
