import java.sql.*;
import java.util.Scanner;

public class InsertIntoUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String URL="jdbc:mysql://localhost:3306/spark6";
        String USER="root";
        String PASSWORD="Sahoo@123";

        System.out.print("Enter Employee id: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee name: ");
        String name=sc.nextLine();
        System.out.print("Enter Employee Department: ");
        String dep=sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        Double sal=sc.nextDouble();

        try {
            String sql="INSERT INTO employee(id,name,dep,sal) VALUES (?,?,?,?)";

            Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,dep);
            preparedStatement.setDouble(4,sal);

            int row=preparedStatement.executeUpdate();

            System.out.println(row+" Employee inserted");


            preparedStatement.close();
            connection.close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
