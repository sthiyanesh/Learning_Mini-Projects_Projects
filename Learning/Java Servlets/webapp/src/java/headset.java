/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import connectdb.Item;
import connectdb.connectdb2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THIYANESH S
 */
@WebServlet(urlPatterns = {"/headset"})
public class headset extends HttpServlet {

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
            out.println("<title>Servlet headset</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet headset at " + request.getContextPath() + "</h1>");
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
        connectdb2 d = new connectdb2();
        Item[] items = d.checkpass("headphone");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>\n" +
"    <head>\n" +
"        <title>My Shopping Website</title>\n" +
"        <link rel=\"stylesheet\" href=\"indexcss.css\">\n" +
"    </head>\n" +
"    <body style=\"background-color: #EDEEF7\">\n" +
"        <div style=\"position: relative; width:100%; height:100%; top:0%; left:0%\">\n" +
"            <div class=\"header\">KingSVT Accessories</div>\n" +
"            <div class=\"topnav\">\n" +
"                <a href=\"\\WebApplication5\\mobile\">Mobile</a>\n" +
"                <a href=\"\\WebApplication5\\laptop\">Laptop</a>\n" +
"                <a href=\"\\WebApplication5\\tablet\">Tablet</a>\n" +
"                <a class=\"active\" href=\"\\WebApplication5\\headset\">Headset</a>\n" +
"                <a href=\"\\WebApplication5\\powerbank\">Power Bank</a>\n" +
"            </div>");
            System.out.println(items.length);
            for(int i=0;i<items.length;i++){
                out.println("<div class=\"content1\">\n" +
"                <table style=\"position: relative;width:100%;height:100%\">\n" +
"                        <td style=\"position: relative;width:40%\"><img src=\""+items[i].lap_img+"\" alt=\"lap1\" style=\"position: relative;width:90%;margin:7.5%;\"/></td>\n" +
"                        <td id=\"text1\">\n" +
"                            <h4>"+items[i].lap_name+"</h4>\n" +
"                            <ul>\n" +
"                                <li>"+items[i].des1+"</li>\n" +
"                                <li>"+items[i].des2+"</li>\n" +
"                                <li>"+items[i].des3+"</li>\n" +
"                                <li>"+items[i].des4+"</li>\n" +
"                            </ul>\n" +
"                            <h4>₹ "+items[i].price+"</h4>\n" +
"                        </td>\n" +
"                </table>\n" +
"            </div>");
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
