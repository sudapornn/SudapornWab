package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.ArrayList;
import java.util.List;
import model.Addfood;

public class DBConnection {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Frenchfries",
                "root", "Suda@04022547");
    }

    //เพิ่ม
    public boolean deleteFoodById(int id) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM food WHERE id = ?";
        try (Connection connection = getConnection(); 
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    
    public List<Addfood> getAllFoods() {
        List<Addfood> foodList = new ArrayList<>();
        String query = "SELECT * FROM food";

        try (Connection con = getConnection(); 
                PreparedStatement ps = con.prepareStatement(query); 
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Addfood food = new Addfood();
                food.setFoodname(rs.getString("name"));
                food.setType(rs.getString("type"));
                food.setCrispness(rs.getString("crispness"));
                food.setHotlevel(rs.getString("hotlevel"));
                food.setSauce(rs.getString("sauce"));
                food.setFoodPrice(rs.getDouble("price"));
                foodList.add(food);
                System.out.println("Food found: " + food.getFoodname() + ", " + food.getType());
            }

        } catch (SQLException e) {
            e.printStackTrace(); // พิมพ์ข้อผิดพลาดเพื่อการตรวจสอบ
        }

        return foodList;
    }
    
    

    public boolean insertNewFood(Addfood food) {
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Frenchfries",
                    "root", "Suda@04022547");

            Statement statement = connection.createStatement();

            String query = "INSERT INTO food "
                    + "(name, type, crispness, hotlevel, sauce, price) "
                    + "VALUES('"
                    + food.getFoodname() + "','"
                    + food.getType() + "','"
                    + food.getCrispness() + "','"
                    + food.getHotlevel() + "','"
                    + food.getSauce() + "',"
                    + food.getFoodPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }

        return result;
    }


    /*
    https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/
     */
    public Addfood getFrenchfries(String name) {
        Addfood food = new Addfood();
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Frenchfries",
                    "root", "Suda@04022547");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM food WHERE name='" + name + "'";
            System.out.println(">>>>>>>>>> query=" + query);

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                food.setFoodname(resultSet.getString("name").trim());
                food.setType(resultSet.getString("type").trim());
                food.setCrispness(resultSet.getString("crispness").trim());
                food.setHotlevel(resultSet.getString("hotlevel").trim());
                food.setSauce(resultSet.getString("sauce").trim());
                food.setFoodPrice(resultSet.getDouble("price"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
        return food;
    }
}




























//    public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection();
//        Addfood food = dbConnection.getFrenchfries("n");
//
//        if (food != null) {
//            System.out.println("Food found:");
//            System.out.println("Name: " + food.getFoodname());
//            System.out.println("Type: " + food.getType());
//            System.out.println("Crispness: " + food.getCrispness());
//            System.out.println("Hotlevel: " + food.getHotlevel());
//            System.out.println("Sauce: " + food.getSauce());
//            System.out.println("Price: " + food.getFoodPrice());
//        } else {
//            System.out.println("Food not found");
//        }
//    }
//  public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection();
//        int testId = 25; // ใช้ ID ที่คุณต้องการลบ
//
//        boolean success = dbConnection.deleteFoodById(testId);
//
//        if (success) {
//            System.out.println("Successfully deleted food item with ID: " + testId);
//        } else {
//            System.out.println("Failed to delete food item with ID: " + testId);
//        }
//    }
//    public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection();
//        List<Addfood> foods = dbConnection.getAllFoods();  // ใช้ List<Addfood> แทน Addfood
//
//        if (foods != null && !foods.isEmpty()) {
//            System.out.println("Foods found:");
//            for (Addfood food : foods) {
//                System.out.println("Name: " + food.getFoodname());
//                System.out.println("Type: " + food.getType());
//                System.out.println("Crispness: " + food.getCrispness());
//                System.out.println("Hotlevel: " + food.getHotlevel());
//                System.out.println("Sauce: " + food.getSauce());
//                System.out.println("Price: " + food.getFoodPrice());
//                System.out.println("---------------------------");
//            }
//        } else {
//            System.out.println("No foods found");
//        }
//    }
