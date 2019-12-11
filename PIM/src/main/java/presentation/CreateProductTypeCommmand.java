package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

public class CreateProductTypeCommmand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        ArrayList<String> enumValues = new ArrayList<>();
        ArrayList<String> productTypeArray = new ArrayList<>();
        String productType = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        ArrayList<String> params = new ArrayList<>();
        Map<String, String[]> parametermap = request.getParameterMap();
        for (String key : parametermap.keySet()) {
            if (key.equalsIgnoreCase("attributes")) {
                columnNames = new ArrayList<>(Arrays.asList(parametermap.get(key)));
            } else if (key.equalsIgnoreCase("enumAttributes")) {
                enumValues = new ArrayList<>(Arrays.asList(parametermap.get(key)));
            } else if (key.equalsIgnoreCase("type")) {
                type = new ArrayList<>(Arrays.asList(parametermap.get(key)));
            } else if (key.equalsIgnoreCase("productType")) {
                productTypeArray = new ArrayList<>(Arrays.asList(parametermap.get(key)));
                productType = productTypeArray.get(0).toString();
            }
        }

        ArrayList<String> generateproducts = new ArrayList();

        generateproducts.add(productType);

        for (int i = 0; i < type.size(); i++) {
            String productsss = "";
            char c = type.get(i).charAt(0);
            productsss = "" + c + "";
            StringBuilder sb = new StringBuilder(productsss);

            productsss += sb.substring(1) + columnNames.get(i).toString();
            generateproducts.add(productsss);

        }
        pMapper.createProductTable(generateproducts, enumValues);
        return returnToShowProducts(request, response);
    }
}
