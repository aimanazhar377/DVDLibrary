/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class AddDVDFormServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        out.println("<h1>Add DVD</h1>");
        out.println("<form action='add_dvd.do' method='POST'>");
            /* TODO output your page here. You may use following sample code. */
            String title = request.getParameter("title");
            // Display the title field
            out.print(" Title: <input type='text' name='title' ");
            if(title == null) 
            {
                title = "";
            }
                
            out.println("value = '" + title + "' /> <br/>");
            String year = request.getParameter("year");
                
            // Display the year field
            out.print(" Year: <input type='text' name='year' ");
            if(year == null) 
            {
                year = "";
            }
                
            out.println("value = '" + year + "' /> <br/>");
        
            //genre
            String genre = request.getParameter("genre");
            String genre_list = "Sci-Fi,Drama,Comedy";
            String [] genres = null;
            genres = genre_list.split(",");
            //Repopulate the Genre drop-down menu
            out.println(" Genre: <select name='genre'>");
            for ( int i = 0; i < genres.length; i++ ) 
            {
                out.print("<option value='" + genres[i] + "'");
                if( genre.equals(genres[i])) 
                {
                    out.print(" selected");
                }
                out.println("> " + genres[i] + "</option>");
            }
                
            out.println("</select>");
            String newGenre = request.getParameter("newGenre");
            out.println(" or new genre: <input type='text' name='newGenre' ");
            if(newGenre == null) 
            {
                newGenre = "";
            }
            out.println("value = '" + newGenre + "'/> <br/>");
            
            out.println("<input type='submit'>");
            out.println("</form>");
        
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
            throws ServletException, IOException 
    {
       processRequest(request, response);
                
                //Retrieve the errorMsgs from the request-scope
                List errorMsgs = (List) request.getAttribute("errorMsgs");
                
                //specify the content type is HTML
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                       
                // Generate the HTML response
                out.println("<html>");
                out.println("<head>");
                out.println("<title> DVD Library Application: Error Page</title>");
                out.println("</head>");
                out.println("<body bgcolor='white'>");
                out.println("<h2>Error Report</h2>");
                out.println("<font color='red'>Please correct the following errors:");
                out.println("<ul>");

                Iterator items = errorMsgs. iterator ();
                while (items. hasNext ()) 
                {
                    String message = (String) items.next();
                    out.println(" <li>" + message + "</li>");
                }
                out.println("</ul>");
                out.println("Back up and try again.");
                out.println("</font>") ;
                out.println("</body>");
                out.println("</html>");
                out.close();
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
