package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

public class ShowProductsCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        String webpage = "ShowProducts";
        ProductMapper pMapper = new ProductMapper();

        ArrayList<String> tableNames = pMapper.getTableNames();

        ArrayList<ArrayList<Product>> products = new ArrayList();

        for (String tableName : tableNames) {
            ArrayList<Product> productType = pMapper.showProducts(tableName);
            products.add(productType);

        }
        ArrayList<String> tables = pMapper.getTableNames();
        ArrayList<String> attributes = new ArrayList<>();

        for (String table : tables) {
            attributes.add(table);
        }
        request.setAttribute("tables", attributes);

        request.setAttribute("tableNames", tableNames);
        request.setAttribute("products", products);

        return webpage;
    }

}
