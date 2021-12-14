/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import TestDB.Connectdb2;
/**
 *
 * @author THIYANESH S
 */
@WebServlet(urlPatterns = {"/DbServlet"})
public class DbServlet extends HttpServlet {

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
            out.println("<title>Servlet DbServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DbServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DBServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div> <h1> Login Status </h1></div>");
            //out.println("<b> parameter 1 : </b>" + request.getParameter("username"));
            //out.println("<br> <b> parameter 2 : </b>" + request.getParameter("password"));
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            Connectdb2 ob = new Connectdb2();
            int status = ob.checkpass(name, pass);
            System.out.println("Login Status: " + status);
            if(status == 0)
            {
                out.println("<h1> Login Success! </h1>");
                out.println("<h2>Welcome " + name + "</h2>");
            }
            else if(status==1){
                out.println("<h1>Passwords dont match</h1>");
                out.println("<h1> Login Failed! </h1>");
            }else if(status==2){
                out.println("<h1>UserName not found</h1>");
                out.println("<h1> Login Failed! </h1>");
            }else{
                out.println("<h1>Unexpected Error Happened</h1>");
                out.println("<h1> Login Failed! </h1>");
            }
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
        // processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DBServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div> <h1> Register Status </h1></div>");
            //out.println("<b> parameter 1 : </b>" + request.getParameter("username"));
            //out.println("<br> <b> parameter 2 : </b>" + request.getParameter("password"));
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            String repass = request.getParameter("rpass");
            if(!pass.equals(repass)){
                out.println("<h1>Passwords dont match</h1>");
            }else{
                Connectdb2 ob = new Connectdb2();
                int status = ob.register(name, pass);
                System.out.println("Register Status: " + status);
                if(status==0){
                    out.println("<h1> Register Success! </h1>");
                    out.println("<h2>Welcome " + name + "</h2>");
                }else if(status==1){
                    out.println("<h1>Username already exists</h1>");
                }else{
                    out.println("<h1>Unexpected Error Happened</h1>");
                }
            }
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
