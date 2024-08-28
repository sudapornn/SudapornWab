<%-- 
    Document   : DeleteItem
    Created on : Aug 21, 2024, 5:08:49 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Food Item</title>
    </head>
    <body>
        <h1>Delete Food Item</h1>
        <form action="DeleteFoodServlet" method="post">
            <label for="id">Enter Food ID to delete:</label><br>
            <input type="text" id="id" name="id" required><br><br>
            <input type="submit" value="Delete Food">
        </form>
        <button onclick="window.location.href = 'index.html';">HOME</button>
    </body>
</html>
