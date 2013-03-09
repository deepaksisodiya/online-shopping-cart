/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.customer;

import com.onlineshopping.product.productBean;
import com.onlineshopping.product.productDAO;
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
public class customerList extends HttpServlet {
   
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
        String customername = request.getParameter("customername");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        customerBean bean = new customerBean();
        customerDAO rd = new customerDAO();
        if (  (customername != null) && (address != null) && (phone != null) && (email != null) && (username != null) && (password != null)) {
            bean.setCustomername(customername);
            bean.setAddress(address);
            bean.setPhone(phone);
            bean.setEmail(email);
            bean.setUsername(username);
            bean.setPassword(password);
        }
        int id = 0;
        try {
            String opn = request.getParameter("opn");
            if (opn.equals("add")) {
                rd.create(bean);
            } else if (opn.equals("update")) {
                id = Integer.parseInt(request.getParameter("customerid"));
                System.out.println(id);
                bean.setCustomerid(id);
                rd.edit(bean);
            } else if (opn.equals("delete")) {
                id = Integer.parseInt(request.getParameter("customerid"));
                bean.setCustomerid(id);
                rd.remove(id);
            }
            response.sendRedirect("customerHome");
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
