package Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertInto {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/spark6";
            String usr = "root";
            String password = "Sahoo@123";
            String sql = """
                    INSERT INTO employee
                    VALUES (4, 'aman', 'IT', 40000)
                    """;

            Connection connection =
                    DriverManager.getConnection(url,usr,password);

            Statement statement=connection.createStatement();

            int row=statement.executeUpdate(sql);
            System.out.println(row+"Rows Impacted");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
