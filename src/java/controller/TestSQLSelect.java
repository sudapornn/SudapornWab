/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLSelect {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Frenchfries",
                    "root", "Suda@04022547");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM food WHERE name='French Fries'");
            String foodname, type, crispness, hotlevel, sauce;
            double foodPrice;

            while (resultSet.next()) {
                foodname = resultSet.getString("name");
                type = resultSet.getString("type").trim();
                crispness = resultSet.getString("crispness").trim();
                hotlevel = resultSet.getString("hotlevel").trim();
                sauce = resultSet.getString("sauce").trim();
                foodPrice = resultSet.getDouble("price");

                System.out.println("Name: " + foodname
                        + ", Type: " + type
                        + ", Crispness: " + crispness
                        + ", Hotlevel: " + hotlevel
                        + ", Sauce: " + sauce
                        + ", Price: " + foodPrice);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }
}
