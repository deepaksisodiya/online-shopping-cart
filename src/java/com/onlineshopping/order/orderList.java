/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.order;

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
public class orderList extends HttpServlet {
   
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
        String orderid = request.getParameter("orderid");
        String orderdate = request.getParameter("orderdate");
        String customerid = request.getParameter("customerid");
        String orderamount = request.getParameter("orderamount");
        String paymentreceived = request.getParameter("paymentreceived");
        
        orderBean bean = new orderBean();
        orderDAO rd = new orderDAO();
        if ((orderid != null) && (orderdate != null) && (customerid != null) && (orderamount != null) && (paymentreceived != null)) {
            bean.setOrderid(Integer.parseInt(orderid));
            bean.setOrderdate(orderdate);
            bean.setCustomerid(Integer.parseInt(customerid));
            bean.setOrderamount(Float.parseFloat(orderamount));
            bean.setPaymentreceived(paymentreceived);
        }
        int id = 0;
        try {
            String opn = request.getParameter("opn");
            if (opn.equals("add")) {
                rd.create(bean);
            } else if (opn.equals("update")) {
                id = Integer.parseInt(orderid);
                System.out.println(id);
                bean.setOrderid(id);
                rd.edit(bean);
            } else if (opn.equals("delete")) {
                id = Integer.parseInt(orderid);
                bean.setOrderid(id);
                rd.remove(id);
            }
            response.sendRedirect("categoryviewforcustomer");
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
