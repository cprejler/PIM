package presentation;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProductMapper;

/**
 *
 * @author jonat
 */
public abstract class Command{
    
    Connection connection;
    

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("UpdateProduct", new UpdateProductCommand());
        commands.put("gotoUpdateProduct", new gotoUpdateProduct());
        commands.put("InsertProduct", new InsertProductCommand());
        commands.put("gotoInsertProduct", new gotoInsertProduct());
        commands.put("DeleteProduct", new DeleteProductCommand());
        commands.put("gotoDeleteProduct", new gotoDeleteProductCommand());
        commands.put("ShowProducts", new ShowProductsCommand());
        commands.put("gotoShowProducts", new gotoShowProducts());
        commands.put("search", new SearchProductCommand());
        commands.put("generateForm", new generateFormCommand());
        commands.put("gotoSpecificProduct", new gotoSpecificProduct());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("cmd");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException;
}
