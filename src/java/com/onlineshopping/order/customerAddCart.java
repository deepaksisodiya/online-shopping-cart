/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.order;

import com.onlineshopping.category.categoryBean;
import com.onlineshopping.category.categoryDAO;
import com.onlineshopping.customer.customerBean;
import com.onlineshopping.customer.customerDAO;
import com.onlineshopping.orderdetails.orderdetailsBean;
import com.onlineshopping.orderdetails.orderdetailsDAO;
import com.onlineshopping.product.productBean;
import com.onlineshopping.product.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author deepak
 */
public class customerAddCart extends HttpServlet {
       protected ArrayList<MasterOrder> items;

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



        String method = request.getParameter("method");
        HttpSession httpSession = request.getSession(true);
        RequestDispatcher dispatcher = null;
        double total = 0, grant = 0;
        int opt = 0;
        int size = 0;
        double total1 = 0;
        opt = Integer.parseInt(request.getParameter("opt"));
        int qty = 1;
        try {
             HttpSession session = request.getSession();

            out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>");
            out.println("<title>Pink Shop Template</title>");
            out.println("<meta name=\"keywords\" content=\"pink shop, store template, ecommerce, online shopping, CSS, HTML\" />");
            out.println("<meta name=\"description\" content=\"Pink Shop is a free ecommerce template provided by templatemo.com\" />");
            out.println("<link href=\"templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet/styles.css\" />");


            out.println("<script language=\"javascript\" type=\"text/javascript\">");
            out.println("function clearText(field)");
            {
                out.println("if (field.defaultValue == field.value) field.value = '';");
                out.println("else if (field.value == '') field.value = field.defaultValue;");
            }
            out.println("</script>");
            out.println("<script language=\"javascript\" type=\"text/javascript\" src=\"scripts/mootools-1.2.1-core.js\"></script>");
            out.println("<script language=\"javascript\" type=\"text/javascript\" src=\"scripts/mootools-1.2-more.js\"></script>");
            out.println("<script language=\"javascript\" type=\"text/javascript\" src=\"scripts/slideitmoo-1.1.js\"></script>");
            out.println("<script language=\"javascript\" type=\"text/javascript\">");
            out.println("window.addEvents({");
            out.println("'domready': function(){");
            /* thumbnails example , div containers */
            out.println("new SlideItMoo({");
            out.println("overallContainer: 'SlideItMoo_outer',");
            out.println("elementScrolled: 'SlideItMoo_inner',");
            out.println("thumbsContainer: 'SlideItMoo_items',");
            out.println("itemsVisible: 5,");
            out.println("elemsSlide: 3,");
            out.println("duration: 200,");
            out.println("itemsSelector: '.SlideItMoo_element',");
            out.println("itemWidth: 140,");
            out.println("showControls:1});");
            out.println("}");

            out.println("});");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"templatemo_wrapper\">");
            out.println("<div id=\"templatemo_menu\">");

            
            dispatcher = request.getRequestDispatcher("/design/menuforCustomer.html");
            dispatcher.include(request, response);

            out.println("<!--menu-->");

            out.println("<!--menu-->");

            out.println("</div> <!-- end of templatemo_menu -->");

            out.println("<div id=\"templatemo_header_bar\">");

            dispatcher = request.getRequestDispatcher("/design/header.html");
            dispatcher.include(request, response);


            out.println("<!--header-->");

            out.println("<!--header-->");

//            dispatcher = request.getRequestDispatcher("/design/search.html");
//            dispatcher.include(request, response);
//
//
//            out.println("<!--search-->");
//
//            out.println("<!--search-->");


            out.println("</div> <!-- end of templatemo_header_bar -->");

            out.println("<div class=\"cleaner\"></div>");
            out.println("<div id=\"sidebar\"><div class=\"sidebar_top\"></div><div class=\"sidebar_bottom\"></div>");


//           dispatcher = request.getRequestDispatcher("/design/member.html");
//           dispatcher.include(request, response);
//
//
//        out.println("<!--member-->");
//
//        out.println("<!--member-->");


            dispatcher = request.getRequestDispatcher("/design/databaseCustomer.html");
            dispatcher.include(request, response);

            out.println("<!--database-->");

            out.println("<!--database-->");


//         dispatcher = request.getRequestDispatcher("/design/discount.html");
//         dispatcher.include(request, response);
//
//        out.println("<!--discount-->");
//
//        out.println("<!--discount-->");


            out.println("<!-- end of sidebar -->");
            out.println("</div>");
            out.println("<div id=\"templatmeo_content\">");
//
//         dispatcher = request.getRequestDispatcher("/design/feature.html");
//         dispatcher.include(request, response);
//
//        out.println("<!--features-->");
//
//        out.println("<!--features-->");
//

            out.println("<!-- end of latest_content_gallery -->");


//        dispatcher = request.getRequestDispatcher("/design/welcome.html");
//        dispatcher.include(request, response);
//
//        out.println("<!--welcome-->");
//
//        out.println("<!--welcome-->");


            out.println("<div class=\"content_section\">");


//         dispatcher = request.getRequestDispatcher("/design/content.html");
//         dispatcher.include(request, response);
//
//         out.println("<!--content-->");


/*

                 if (method.equals("add")) {
                MasterOrder bn = new MasterOrder();
                int ic = Integer.parseInt(request.getParameter("productid"));
                bn.setProductid(ic);
                bn.setProductname(request.getParameter("productname"));
                bn.setQuantity(qty);
                double pri = Double.parseDouble(request.getParameter("productprice"));
                bn.setProductprice(pri);
                bn.setSubtotal(pri);
                int qty1 = 0;
                if (items == null) {
                    items = new ArrayList<MasterOrder>();
                }
                boolean currIndex = items.isEmpty();
                if (currIndex) {
                    items.add(bn);
                    System.out.println("items" + items);
                    httpSession.setAttribute("items", items);

                } else {
                    Boolean itemExists = false;
                    for (Iterator it = items.iterator(); it.hasNext();) {
                        Object o = it.next();
                        MasterOrder shop = (MasterOrder) o;
                        if (shop.getProductid() == bn.getProductid()) {
                            int qt = shop.getQuantity();
                            double pr = shop.getProductprice();
                            qty1 = 1 + qt;
                            total = qty1 * pr;
                            shop.setQuantity(qty1);
                            shop.setSubtotal(total);
                            itemExists = true;
                        }

                    }
                    if (!itemExists) {
                        items.add(bn);
                        httpSession.setAttribute("items", items);
                    }
                }
                ArrayList al = (ArrayList) httpSession.getAttribute("items");
                Iterator itr = al.iterator();
                size = al.size();
                while (itr.hasNext()) {
                    MasterOrder scbn = (MasterOrder) itr.next();
                    double price = 0;
                    price = scbn.getProductprice() * scbn.getQuantity();
                    total1 = total1 + price;
                }
                httpSession.setAttribute("size", size);
                httpSession.setAttribute("grant", total1);
                httpSession.setAttribute("pid", ic);
                httpSession.setAttribute("price", pri);
                httpSession.setAttribute("qty", qty1);
            } else if (method.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("productid"));
                System.out.println("id delete" + id);
                for (Iterator it = items.iterator(); it.hasNext();) {
                    Object o = it.next();
                    MasterOrder shop = (MasterOrder) o;
                    if (shop.getProductid() == id) {
                        items.remove(o);
                    }
                }
                httpSession.setAttribute("items", items);
                httpSession.setAttribute("size", size);
                httpSession.setAttribute("grant", total1);



//                dispatcher = request.getRequestDispatcher("/pages/customer/AddToCart.jsp");
                out.print("<span style='color: RED'>Item Deleted</span>");
            } else if (method.equals("update")) {
                int id = Integer.parseInt(request.getParameter("productid"));
                int qty1 = Integer.parseInt(request.getParameter("quantity"));
                ArrayList<MasterOrder> newItem = new ArrayList<MasterOrder>();
                for (Iterator it = items.iterator(); it.hasNext();) {
                    Object o = it.next();
                    MasterOrder shop = (MasterOrder) o;
                    if (shop.getProductid() == id) {
                        shop.setQuantity(qty1);
                    }
                    newItem.add(shop);
                }

                System.out.println("qty  " + request.getParameter("quantity"));
                out.print("<span style='color: green'>Quantity Changed</span>");
            }




            if (opt == 1) {
        //        dispatcher = request.getRequestDispatcher("/pages/customer/BuyNow.jsp");


                out.println("hello");


            } else {

               // dispatcher = request.getRequestDispatcher("/pages/customer/AddToCart.jsp");
            }

            dispatcher.forward(request, response);


*/




            	ArrayList arl= (ArrayList)session.getAttribute("arl");
	int index=-1;
	if(arl==null){
			arl = new ArrayList();
			session.setAttribute("arl",arl);
		     }
	synchronized(arl)
	{
		//if(request.getParameter("add")!=null)
                if(method.equals("add"))
            {
			String productname = request.getParameter("productname");
			String productprice = request.getParameter("productprice");
                         String productid=request.getParameter("productid");
			MasterOrder m = new MasterOrder();
			m.setData1(Integer.parseInt(productid),productname,Float.parseFloat(productprice));
			arl.add(m);

out.println("<html><head><title>Added Member</title></head>");
out.println("<body><center><h2> Add to Cart :</h2><br>");

//out.println("<ul>");
out.println("<table><tr><th>Product Name</th><th>Product Price</th></tr>");
for(int i =0;i<arl.size();i++)
			{
				MasterOrder mem = (MasterOrder)arl.get(i);
out.println("<tr><td>"+mem.getProductname()+" </td><td>"+mem.getProductprice()+"</td></tr>");
			}
out.println("</table>");
customerBean bean = new customerBean();
out.println("<a href=\"/orderList?&opn=add&now()&customerid" + bean.getCustomerid() + "\">Buy</a>");



//out.println("<tr><td>"+m.getProductname()+"</td><td>"+m.getProductprice()+"</td></tr></table>");
out.println("</body></html>");
		}

                }





//           out.println("<!--content-->");
////

            out.println("</div>");

            out.println("</div> <!-- end of templatmeo_content -->");


            out.println("</div> <!-- end of templatemo_wrapper -->");

            out.println("<div id=\"templatemo_footer_wrapper\">");


            dispatcher = request.getRequestDispatcher("/design/adminHomeFooter.html");
            dispatcher.include(request, response);

            out.println("<!--footer-->");

            out.println("<!--footer-->");


            out.println("</div> <!-- end of footer_wrapper -->");
            out.println("<!--line below footer-->");

            out.println("<!--line below footer-->");
            out.println("</body>");
            out.println("</html>");

        } finally { 
            out.close();
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
