import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExample {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/spark6";
            String usr = "root";
            String password = "Sahoo@123";
            String sql = """
                    UPDATE employee SET sal=90000 where id=1
                    """;

            Connection connection =
                    DriverManager.getConnection(url,usr,password);

            Statement statement=connection.createStatement();

            int row =statement.executeUpdate(sql);
            if(row>0)
            {
                System.out.println("Employee Updated Successfully");
            }
            else
            {
                System.out.println("Employee not found");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
