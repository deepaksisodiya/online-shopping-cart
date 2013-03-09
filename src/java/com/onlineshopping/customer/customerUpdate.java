/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.customer;

import java.io.IOException;
import java.io.PrintWriter;
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
public class customerUpdate extends HttpServlet {
   
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

         RequestDispatcher dispatcher;
         dispatcher = request.getRequestDispatcher("/design/menu.html");
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


          dispatcher = request.getRequestDispatcher("/design/database.html");
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
           out.println("<form method=\"post\" action=\"customerListforAdmin?opn=update\"  onSubmit=\"return validate(this);\">");
            int id = Integer.parseInt(request.getParameter("customerid"));
            customerDAO cd = new customerDAO();
            customerBean bean = cd.find(id);
            out.println("<input type=\"hidden\" name=\"customerid\" value="+bean.getCustomerid()+">");
            out.println("<b>Customer Name : </b> <input type=\"text\" name=\"customername\" value="+bean.getCustomername()+"> <br/>");
            out.println("<b>Address : </b> <input type=\"text\" name=\"address\" value="+bean.getAddress()+"><br/> ");
            out.println("<b>Mobile No: </b> <input type=\"text\" name=\"phone\" value="+bean.getPhone()+"><br/> ");
            out.println("<b>Email ID: </b> <input type=\"text\" name=\"email\" value="+bean.getEmail()+"><br/> ");
            out.println("<b>UserName: </b> <input type=\"text\" name=\"username\" value="+bean.getUsername()+"><br/> ");
            out.println("<b>Password: </b> <input type=\"password\" name=\"password\" value="+bean.getPassword()+"><br/> ");
            out.println("<input type=\"submit\" value=\"Update\"/>");
            out.println("<input type=\"reset\" value=\"Clear Contents\"/>");
            out.println("</form>");

//         out.println("<!--content-->");
//

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
