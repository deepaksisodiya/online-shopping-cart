/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.category;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deepak
 */
public class categoryList extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String categoryname = request.getParameter("categoryname");
        String categorydetails = request.getParameter("categorydetails");
        categoryBean bean = new categoryBean();
        categoryDAO rd = new categoryDAO();
        if ((categoryname != null) && (categorydetails != null)) {
           
            bean.setCategoryname(categoryname);
            bean.setCategorydetails(categorydetails);
        }
        int id = 0;
        
        
            try {
            String opn = request.getParameter("opn");
            if (opn.equals("add")) {
                rd.create(bean);
            } else if (opn.equals("update")) {
                id = Integer.parseInt(request.getParameter("categoryid"));
                System.out.println(id);
                bean.setCategoryid(id);
                rd.edit(bean);
            } else if (opn.equals("delete")) {
                id = Integer.parseInt(request.getParameter("categoryid"));
                bean.setCategoryid(id);
                rd.remove(id);
            }
            response.sendRedirect("categoryview");
        } finally {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
