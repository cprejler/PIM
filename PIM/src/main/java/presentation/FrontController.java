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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FormGenerator;
import persistence.ProductMapper;

/**
 *
 * @author casper
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
    //@TODO  DET HER  SKAL RYKKES OVER I CMD  INTERFACE.
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        if(request.getParameter("cmd").equals("showItems")){
            showProducts(request, response);
        }else if(request.getParameter("cmd").equals("gotoInsertProduct")){
            gotoInsertProduct(request, response);
            
        }else if(request.getParameter("cmd").equals("generateForm")){
            generateForm(request, response);
        }else  if(request.getParameter("cmd").equals("insertProduct")){
            insertProduct(request, response);
        }
        
        
        }
    
    
    
    
    protected void showProducts(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
        //@TODO  For each product type in the database call showProduct and then send  it over
        ProductMapper  pMapper  =  new  ProductMapper();
        
        ArrayList<Product>  wine = pMapper.showProducts("wine");
        ArrayList<Product> phones = pMapper.showProducts("phone");
        wine.get(0).getFieldsValues();
        
        
        
        request.setAttribute("wine", wine);
        request.setAttribute("phones", phones);
        
        
        RequestDispatcher rd =  request.getRequestDispatcher("test.jsp");
        rd.forward(request, response);
        
    }
    
    protected void gotoInsertProduct(HttpServletRequest  request,  HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd  = request.getRequestDispatcher("InsertProduct.jsp");
        rd.forward(request, response);
    }
    
    protected void insertProduct (HttpServletRequest  request,  HttpServletResponse response) throws ClassNotFoundException, SQLException{
        
        //WORK  IN PROGRESS
        Map params  =  request.getParameterMap();
        String  manufacturer = (String)params.get("manufacturer");
        String  productName = (String)params.get("productName");
        String  productType = (String)params.get("productType");
        
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<Object> fieldValues = new ArrayList<>();
        
        for (Object key : params.keySet()) {
            if(!key.equals("manufacturer") && !key.equals("productName") && !key.equals("productType")){
                String keyStr  = (String)key;
                fields.add(keyStr);
                fieldValues.add(params.get("keyStr"));
            }
            
        }
        
        Product product = new  Product(productName, "test", productType, manufacturer, fields, fieldValues);
        
        ProductMapper pMapper = new ProductMapper();
        
        pMapper.insertProduct(product);
        
        
        
        
        
    }
    
    protected void generateForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
        String  formToGenerate  = request.getParameter("productType");
        FormGenerator fg  = new FormGenerator();
        ArrayList<HashMap<String,Object>> forms = fg.generateForm(formToGenerate);
        request.setAttribute("forms", forms);
        
        RequestDispatcher rd = request.getRequestDispatcher("InsertProductType.jsp");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
