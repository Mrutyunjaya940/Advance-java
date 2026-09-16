package Dynamic;

import java.sql.*;
import java.util.Scanner;

public class InserxExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            String url="jdbc:mysql://localhost:3306/spark6";
            String usr="root";
            String password="Sahoo@123";


            System.out.print("Enter Employee id: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee name: ");
            String name=sc.nextLine();

            System.out.print("Enter Employee Department: ");
            String dep=sc.nextLine();
            System.out.print("Enter Employee Salary: ");
            Double sal=sc.nextDouble();


            String sql="INSERT INTO employee(id,name,dep,sal) VALUES (?,?,?,?)";

            //System.out.println(sql);
            Connection connection= DriverManager.getConnection(url,usr,password);
            Statement statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,dep);
            preparedStatement.setDouble(4,sal);

            int row=preparedStatement.executeUpdate();

            System.out.println(row+" Employee inserted");


        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
