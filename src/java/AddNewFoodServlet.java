/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import model.Addfood;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
@WebServlet(urlPatterns = {"/AddNewFoodServlet"})
public class AddNewFoodServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            Addfood newFood = (Addfood) session.getAttribute("newFood");

            if (newFood == null) {
                String foodname = request.getParameter("foodname");
                String type = request.getParameter("Type");
                String crispness = request.getParameter("crispness");
                String hotlevel = request.getParameter("hotlevel");
                String sauce = request.getParameter("Sauce");
                int foodPrice = Integer.parseInt(request.getParameter("foodPrice").trim());

                newFood = new Addfood();
                newFood.setFoodname(foodname);
                newFood.setType(type);
                newFood.setCrispness(crispness);
                newFood.setHotlevel(hotlevel);
                newFood.setSauce(sauce);
                newFood.setFoodPrice(foodPrice);

                session.setAttribute("newFood", newFood);

                out.println("<h2>New Food Added</h2>");
                out.println("<p>Name: " + newFood.getFoodname() + "</p>");
                out.println("<p>Type: " + newFood.getType() + "</p>");
                out.println("<p>Crispness: " + newFood.getCrispness() + "</p>");
                out.println("<p>Spicy: " + newFood.getHotlevel() + "</p>");
                out.println("<p>Sauce: " + newFood.getSauce() + "</p>");
                out.println("<p>Price: $" + newFood.getFoodPrice() + "</p>");
                out.println("<br/><a href='addNewFoodForm.html'>Edit French Fries</a>");
            } else {
                out.println("<h2>Food Details</h2>");
                out.println("<p>Name: " + newFood.getFoodname() + "</p>");
                out.println("<p>Type: " + newFood.getType() + "</p>");
                out.println("<p>Crispness: " + newFood.getCrispness() + "</p>");
                out.println("<p>Spicy: " + newFood.getHotlevel() + "</p>");
                out.println("<p>Sauce: " + newFood.getSauce() + "</p>");
                out.println("<p>Price: $" + newFood.getFoodPrice() + "</p>");
                out.println("<br/><a href='addNewFoodForm.html'>Edit French Fries</a>");
                session.removeAttribute("newFood");

            }
        } catch (Exception e) {
            response.sendRedirect("error.html");
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
