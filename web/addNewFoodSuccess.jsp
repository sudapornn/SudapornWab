<%-- 
    Document   : addNewFoodSuccess
    Created on : Jul 17, 2024, 4:26:52 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Addfood" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Add FrenchFrie Success</h1>
        <%
            Addfood newFood = (Addfood) session.getAttribute("newFood");
        %>
        Namefood: <%= newFood.getFoodname() %><br/>
        Type: <%= newFood.getType() %><br/>
        Crispness: <%= newFood.getCrispness() %><br/>
        Spicy: <%= newFood.getHotlevel() %><br/>
        Sauce: <%= newFood.getSauce() %><br/> 
        Price: <%= newFood.getFoodPrice() %><br/>
        <a href="ShowUpdatedFood.jsp">Edit French Fries</a>
    </body>
</html>
