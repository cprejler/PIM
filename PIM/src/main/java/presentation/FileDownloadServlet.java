/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import persistence.ExcelWriter;

/**
 *
 * @author casper
 */
@WebServlet(name = "FileDownloadServlet", urlPatterns = {"/FileDownloadServlet"})
public class FileDownloadServlet extends HttpServlet {

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

        //Check if the command is Excel or JSON
        if (request.getParameter("cmd").equals("exportExcel")) {
            ExcelWriter excelWriter = new ExcelWriter();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            //response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-disposition", "attachment; filename=products.xlsx");
            
            
            
            try {
                
                
                File file = new File(System.getenv("user.home"),"products.xlsx");
                
                Workbook workbook = excelWriter.createWorkBook();
                
                FileOutputStream out = new FileOutputStream(file);
                
                workbook.write(out);
                
                out.close();
                workbook.close();
                
                FileInputStream fInputStream = new FileInputStream(file);
                
                int size = 8000;
                
                response.setContentLength(fInputStream.available());
                
                byte[] buffer = new byte[size];
                
                ServletOutputStream outputStream = null;
                
                outputStream = response.getOutputStream();
                
                int length = 0;
                
                while ((length = fInputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, length);
                }
                fInputStream.close();
                outputStream.flush();
                outputStream.close();
                
                

            } catch (Exception e) {
                Logger.getLogger(FileDownloadServlet.class.getName()).log(Level.SEVERE, null, e);
            }
            RequestDispatcher rd = request.getRequestDispatcher("DataExport.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("cmd").equals("exportJSON")) {

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
            throws ServletException, IOException, FileNotFoundException {
        processRequest(request, response);

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
