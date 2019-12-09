package presentation;


import businesslogic.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
        commands.put("ShowProducts", new ShowProductsCommand());
        commands.put("search", new SearchProductCommand());
        commands.put("generateForm", new generateFormCommand());
        commands.put("generateFilter", new generateFilterCommand());
        commands.put("gotoSpecificProduct", new gotoSpecificProduct());
        commands.put("CreateProductType", new CreateProductTypeCommmand());
        commands.put("gotoCreateProductType", new gotoCreateProductType());
        commands.put("applyFilter", new ApplyFilterCommand());

    }
    
        public String returnToShowProducts (HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException  {
        String webpage = "ShowProducts_1";
        ProductMapper pMapper = new ProductMapper();
        ArrayList<String> tableNames = pMapper.getTableNames();
        ArrayList<ArrayList<Product>> products = new ArrayList();
        for (String tableName : tableNames) {
            ArrayList<Product> productType   = pMapper.showProducts(tableName);
            products.add(productType);
            
        }
        
        request.setAttribute("tableNames", tableNames);
        request.setAttribute("products", products);
        return webpage; 
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
