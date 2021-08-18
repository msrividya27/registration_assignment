/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author maddi
 */
public class registration1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registration1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            String name=request.getParameter("name");   
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            String gender=request.getParameter("gender");
            Class.forName("com.mysql.jdbc.Driver");
            //out.println(uname);
            //step2: connecting to db
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","");
            String q="INSERT INTO register VALUES (?,?,?,?)";
            
           PreparedStatement stmt=con.prepareStatement(q);
            stmt.setString(1,name);   //1 specifies the first parameter in the query
            stmt.setString(2,email);
            stmt.setString(3,phone);
            stmt.setString(4,gender);
            //step4: process resultset
            int i=stmt.executeUpdate();
            out.println("<h1>"+name+", registered successfully!!</h1>"); 
            /* TODO output your page here. You may use following sample code. */
            con.close();
             out.println("</center>");

            out.println("</body>");
            out.println("</html>");
        }
        
        catch(Exception e){PrintWriter out = response.getWriter();out.println("hello");}
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
