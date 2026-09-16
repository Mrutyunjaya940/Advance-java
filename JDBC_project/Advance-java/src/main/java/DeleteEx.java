import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEx {
    public static void main(String[] args)  {
        try {
            String url = "jdbc:mysql://localhost:3306/spark6";
            String usr = "root";
            String password = "Sahoo@123";
            String sql = """
                    DELETE FROM employee WHERE id =6;
                    """;

            Connection connection = DriverManager.getConnection(url, usr, password);
            Statement statement= connection.createStatement();
           int row= statement.executeUpdate(sql);
            System.out.println(row+" this much rows wass deleted");

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
