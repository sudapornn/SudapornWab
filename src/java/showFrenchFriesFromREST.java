/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author LENOVO
 */
public class showFrenchFriesFromREST extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String foodname = request.getParameter("foodname");

        foodname = URLEncoder.encode(foodname, "UTF-8");
        String url = "http://localhost:8080/SudapornWab/getFoodDataService/" + foodname;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {
            String json = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                json += scanner.nextLine();
                json += "\n";
            }
            scanner.close();
            out.println("<br/><br/>");

            System.out.println("..............>>>>>>>>>>>>>>");
            JSONObject jsonObject = new JSONObject(json);
            System.out.println(jsonObject.toString());

            String name = jsonObject.getString("name");
            name = URLDecoder.decode(name, "UTF-8");
            String type = jsonObject.getString("type");
            String crispness = jsonObject.getString("crispness");
            String hotlevel = jsonObject.getString("hotlevel");
            String sauce = jsonObject.getString("sauce");
            String price = jsonObject.getString("foodPrice");

            out.println("Food data from REST <br/>");
            out.println("Name: " + name + "<br/>");
            out.println("Type: " + type + "<br/>");
            out.println("Crispness: " + crispness + "<br/>");
            out.println("Hotlevel: " + hotlevel + "<br/>");
            out.println("Sauce: " + sauce + "<br/>");
            out.println("Price: " + price + " baht"+ "<br/>");
            out.println("<button onclick=\"window.location.href='getFrenchFriesFoodREST.jsp';\">Return to search page</button>");

        } else {
            out.println("ERROR ... responseCode=" + responseCode);
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
