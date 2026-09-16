package com.cfs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentService service=new StudentService();
        Scanner sc=new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("=============Student Management System===============");
            System.out.println("1. Add Student");
            System.out.println("2. View all Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exist");

            System.out.println();
            System.out.print("Enter your Choice: ");
            choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter Student id: ");
                    int id=sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student name: ");
                    String name=sc.nextLine();

                    System.out.print("Enter Student email: ");
                    String email=sc.nextLine();

                    System.out.print("Enter Your Course: ");
                    String course=sc.nextLine();

                    System.out.print("Enter Student Marks: ");
                    Double marks=sc.nextDouble();

                    Student student=new Student(id,name,email,course,marks);
                    service.addStudent(student);
                    break;

                case 2:
                    service.viewallStudents();
                    break;

                case 3:
                    System.out.println("Enter Student id: ");
                    int newId=sc.nextInt();
                    sc.nextLine();
                    service.searchById(newId);
                    break;

                case 4:
                    System.out.println("Enter id: ");
                    int Sid=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Updated mark: ");
                    double Umark=sc.nextDouble();
                    service.updateStudet(Sid,Umark);

                    break;

                case 5:
                    System.out.println("Enter Student ID: ");
                    int DeleteId= sc.nextInt();
                    service.DeletStudent(DeleteId);
                    break;

                case 6:
                    System.out.println("Application closed !");
                    break;

                default:
                    System.out.println("Invalid input.");
            }

        }while (choice != 6);
        {
            System.out.println("Invalid input.");
        }

    }
}
