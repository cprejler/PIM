package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

public class ApplyFilterCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "FilteredProducts";
        ProductMapper pMapper = new ProductMapper();
        Enumeration<String> getParameterNames = request.getParameterNames();
        ArrayList<String> parameterNames = new ArrayList<>();

        while (getParameterNames.hasMoreElements()) {
            parameterNames.add(getParameterNames.nextElement());

        }
        ArrayList<String> parameters = new ArrayList<String>();

        for (String parameterName : parameterNames) {
            if (!parameterName.equals("cmd")) {
                parameters.add(request.getParameter(parameterName));
            }

        }

        ArrayList<Product> filteredProducts = pMapper.filteredProducts(parameters.get(2), parameters.get(1), parameters.get(0));

        request.setAttribute("filteredProducts", filteredProducts);

        return webpage;

    }

}
