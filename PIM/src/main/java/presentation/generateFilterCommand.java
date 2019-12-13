package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FilterGenerator;
import persistence.ProductMapper;

public class generateFilterCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "SearchAndFilter";
        String filterToGenerate = request.getParameter("productType");

        FilterGenerator fg = new FilterGenerator();
        ArrayList<Filter> filters = fg.generateFilter(filterToGenerate);

        request.setAttribute("filters", filters);

        //Send table names in order to dynamically generate dropdown boxes, if user wants to change product type
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tables = pMapper.getTableNames();

        ArrayList<Product> productType = pMapper.showProducts(filterToGenerate);
        ArrayList<String> attributes = new ArrayList<>();

        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("tables", attributes);

        request.setAttribute("productType", filterToGenerate);
        request.setAttribute("getProductType", productType);

        return webpage;
    }

}
