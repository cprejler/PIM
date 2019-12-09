/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import persistence.ChooseConnection;

/**
 *
 * @author casper
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
@MultipartConfig(maxFileSize=16177215) //Upload filesize is 16 mb
public class FileUploadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
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
        processRequest(request, response);
        
        
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
        processRequest(request, response);
        
        
        
        
        
        
        
        String getProductID = request.getParameter("productID");
        Integer productID = Integer.parseInt(getProductID);
        
        InputStream inputStream = null; //input stream  of the file
        
        Part filePart = request.getPart("image");
        //Get input stream of uploaded file
        inputStream = filePart.getInputStream();
        
        
        try {
            ChooseConnection cv = new ChooseConnection();
            Connection connection = cv.chooseConnections();
            String sql = "INSERT INTO images (image, productID) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBlob(1, inputStream);
            statement.setInt(2, productID);
            statement.execute();
            request.getRequestDispatcher("/FrontController?cmd=gotoUpdateProduct&selectedEdit="+productID+"").forward(request, response);
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
             
            request.setAttribute("error", e.getMessage());
            request.setAttribute("cause", e.getCause());
            request.setAttribute("stacktrace", e.getStackTrace());
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
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
