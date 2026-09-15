package com.vendor.spring;

import java.sql.*;

public class ReadExample {
     public static void main(String[] args) throws SQLException {

         try {
             String URL = "jdbc:mysql://localhost:3306/spark6";
             String USERNAME = "root";
             String PASSWORD = "Sahoo@123";
             String sql = "SELECT * FROM employee";

             Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);

             while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
                 String dep = resultSet.getString("dep");
                 Double sal = resultSet.getDouble("sal");

                 System.out.println(
                         id+" | "+
                         name+" | "+
                         dep+" | "+
                         sal+" | "
                         );
             }

         } catch (Exception e) {
             System.out.println("Can't connected");
             e.printStackTrace();
         }
    }
}
