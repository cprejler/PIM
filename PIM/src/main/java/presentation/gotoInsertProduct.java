package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

public class gotoInsertProduct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String webpage = "InsertProduct";
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
