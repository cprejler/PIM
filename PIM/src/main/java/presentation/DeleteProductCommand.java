package presentation;

import businesslogic.Product;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

public class DeleteProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        ProductMapper pMapper = new ProductMapper();

        String productId = request.getParameter("productID");

        Product product = pMapper.getProduct(Integer.parseInt(productId));

        try {
            pMapper.deleteProduct(product);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("cause", e.getCause());
            request.setAttribute("stacktrace", e.getStackTrace());
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);

        }

        return returnToShowProducts(request, response);

    }

}
