package com.cfs;

import java.sql.*;

public class StudentService {
     String url="jdbc:mysql://localhost:3306/jdbc_project01";
     String userName="root";
     String pass="Sahoo@123";

    public void addStudent(Student student){
        String sql="INSERT INTO student (name,email,course,marks) VALUES (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url,userName,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3,student.getCourse());
            preparedStatement.setDouble(4,student.getMark());

            int Rows=preparedStatement.executeUpdate();
            if(Rows>0)
            {
                System.out.println(Rows+" Student added successfully");
            }

            connection.close();
            preparedStatement.close();
        }catch (SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void viewallStudents()  {
        String sql="SELECT * FROM student";
        try {

            Connection connection = DriverManager.getConnection(url, userName, pass);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            System.out.println();
            System.out.println("Student record");
            System.out.println("------------------------------");
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String course=resultSet.getString("course");
                Double marks=resultSet.getDouble("marks");

                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("email: "+email);
                System.out.println("course: "+course);
                System.out.println("marks: "+marks);
                System.out.println("-------------------------------");
            }
            connection.close();
            preparedStatement.close();
        }catch (SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void searchById(int id){
        String sql="SELECT * FROM student WHERE id=?";
        try {

            Connection connection = DriverManager.getConnection(url, userName, pass);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next())
            {
                System.out.println();
                System.out.println("Student Found.");
                System.out.println("Id "+resultSet.getInt("id"));
                System.out.println("Id "+resultSet.getString("name"));
                System.out.println("Id "+resultSet.getString("email"));
                System.out.println("Id "+resultSet.getString("course"));
                System.out.println("Id "+resultSet.getDouble("marks"));


            }


        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }



    public void updateStudet(int id,double mark){
        String sql="UPDATE student SET marks = ? WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(url,userName,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setDouble(1,mark);
            preparedStatement.setInt(2,id);

            int rowAfected=preparedStatement.executeUpdate();
            if(rowAfected>0)
            {
                System.out.println(rowAfected+" Student mark Updated successfully");
            }else
                System.out.println("Student not found !");

            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void DeletStudent(int deleteId)
    {
        String sql="DELETE FROM student WHERE id=?";
        try {
            Connection connection=DriverManager.getConnection(url,userName,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,deleteId);
            int rows=preparedStatement.executeUpdate();
            if(rows>0)
            {
                System.out.println(rows+" Student Deleted Successfully");
            }
            else
            {
                System.out.println("Enter Wrong id !");
            }
            connection.close();
            preparedStatement.close();

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
