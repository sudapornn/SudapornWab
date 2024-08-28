/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import model.Addfood;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Addfood newFood = (Addfood) session.getAttribute("newFood");

            if (newFood == null) {
                // Get parameters from the form
                String foodname = request.getParameter("foodname");
                String type = request.getParameter("Type");
                String crispness = request.getParameter("crispness");
                String hotlevel = request.getParameter("hotlevel");
                String sauce = request.getParameter("Sauce");
                String foodPriceStr = request.getParameter("foodPrice");
                 int foodPrice = Integer.parseInt(request.getParameter("foodPrice"));


                // Create a new Addfood object
                newFood = new Addfood();
                newFood.setFoodname(foodname);
                newFood.setType(type);
                newFood.setCrispness(crispness);
                newFood.setHotlevel(hotlevel);
                newFood.setSauce(sauce);
                newFood.setFoodPrice(foodPrice);

                // Store the Addfood object in the session
                session.setAttribute("newFood", newFood);

                // Output confirmation
                out.println("<h2>New Food Added</h2>");
                out.println("<p>Name: " + newFood.getFoodname() + "</p>");
                out.println("<p>Type: " + newFood.getType() + "</p>");
                out.println("<p>Crispness: " + newFood.getCrispness() + "</p>");
                out.println("<p>Spicy: " + newFood.getHotlevel() + "</p>");
                out.println("<p>Sauce: " + newFood.getSauce() + "</p>");
                out.println("<p>Price: $" + newFood.getFoodPrice() + "</p>");
                out.println("<br/><a href='addNewFoodForm.html'>Add Another Food</a>");
            } else {
                out.println("<h2>Food Details</h2>");
                out.println("<p>Name: " + newFood.getFoodname() + "</p>");
                out.println("<p>Type: " + newFood.getType() + "</p>");
                out.println("<p>Crispness: " + newFood.getCrispness() + "</p>");
                out.println("<p>Spicy: " + newFood.getHotlevel() + "</p>");
                out.println("<p>Sauce: " + newFood.getSauce() + "</p>");
                out.println("<p>Price: $" + newFood.getFoodPrice() + "</p>");
                out.println("<br/><a href='addNewFoodForm.html'>Add Another Food</a>");
                session.removeAttribute("newFood");
            }
        } catch (Exception e) {
            response.getWriter().println("ERROR: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for handling user information in session";
    }
}
