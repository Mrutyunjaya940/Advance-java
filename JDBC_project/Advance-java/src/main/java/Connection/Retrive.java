package Connection;

import java.sql.*;

public class Retrive {
    public static void main(String[] args) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/spark6";
            String usr = "root";
            String password = "Sahoo@123";
            String sql = "SELECT * FROM employee";

            Connection connection = DriverManager.getConnection(url, usr, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String dep=resultSet.getString("dep");
                double sal=resultSet.getDouble("sal");

                System.out.println(
                        id+" | "+
                                name+" | "+
                                dep+" | "+
                                sal+" | "
                );
            }

        }catch (SQLException e)
        {
            System.out.println(e.getStackTrace());
        }
    }
}
