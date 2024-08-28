<%-- 
    Document   : ShowUpdatedFood
    Created on : Jul 17, 2024, 2:57:23 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Addfood" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Edit French Fries</h1>
        <%
            Addfood newFood = (Addfood) session.getAttribute("newFood");
            out.println("ข้อมูลเดิม: " + "Name: "+ newFood.getFoodname() + ", " + "Type: "+ newFood.getType()
                    + ", " +"Crisness: "+  newFood.getCrispness()+ ", " +"Hotlevel: "+  newFood.getHotlevel()+ ", " 
                    + "Sauce: "+ newFood.getSauce()+ ", " +"Price: "+  newFood.getFoodPrice()+ "<br/>");
        %>
        <form action="AddNewFoodServlet2" method="post">
            <label for="foodname">Name food:</label><br>
            <input type="text" id="foodname" name="foodname" value="<%= newFood.getFoodname()%>" required><br>

            <label for="Type">Type:</label><br>
            <select id="Type" name="Type">
                <option value="Waffle Fries" <%= newFood.getType().equals("Waffle Fries") ? "selected" : ""%>>Waffle Fries</option>
                <option value="Curly Fries" <%= newFood.getType().equals("Curly Fries") ? "selected" : ""%>>Curly Fries</option>
                <option value="Regular Fries" <%= newFood.getType().equals("Regular Fries") ? "selected" : ""%>>Regular Fries</option>
                <option value="Tornado Fries" <%= newFood.getType().equals("Tornado Fries") ? "selected" : ""%>>Tornado Fries</option>
            </select><br>

            <label>Crispness:</label><br>
            <input type="checkbox" id="crispness1" name="crispness" value="not crispy" <%= newFood.getCrispness().equals("not crispy") ? "checked" : ""%>>
            <label for="crispness1">Not crispy</label><br>
            <input type="checkbox" id="crispness2" name="crispness" value="little crispy" <%= newFood.getCrispness().equals("little crispy") ? "checked" : ""%>>
            <label for="crispness2">Little crispy</label><br>
            <input type="checkbox" id="crispness3" name="crispness" value="very crispy" <%= newFood.getCrispness().equals("very crispy") ? "checked" : ""%>>
            <label for="crispness3">Very crispy</label><br>

            <label>Spicy:</label><br>
            <input type="radio" id="hotlevel1" name="hotlevel" value="no spicy" <%= newFood.getHotlevel().equals("no spicy") ? "checked" : ""%>>
            <label for="hotlevel1">No spicy</label><br>
            <input type="radio" id="hotlevel2" name="hotlevel" value="less spicy" <%= newFood.getHotlevel().equals("less spicy") ? "checked" : ""%>>
            <label for="hotlevel2">Less spicy</label><br>
            <input type="radio" id="hotlevel3" name="hotlevel" value="very spicy" <%= newFood.getHotlevel().equals("very spicy") ? "checked" : ""%>>
            <label for="hotlevel3">Very spicy</label><br>

            <label for="Sauce">Sauce:</label><br>
            <select id="Sauce" name="Sauce">
                <option value="Tomato ketchup" <%= newFood.getSauce().equals("Tomato ketchup") ? "selected" : ""%>>Tomato ketchup</option>
                <option value="chili sauce" <%= newFood.getSauce().equals("chili sauce") ? "selected" : ""%>>Chili sauce</option>
            </select><br>

            <label for="foodPrice">Price:</label><br>
            <input type="text" id="foodPrice" name="foodPrice" value="<%= newFood.getFoodPrice()%>" required><br>
            <input type="submit" value="Edit French Fries">
            <button onclick="window.location.href='index.html';">HOME</button>
        </form>
        <%
            session.removeAttribute("newFood");
        %>
    </body> 
</html>


