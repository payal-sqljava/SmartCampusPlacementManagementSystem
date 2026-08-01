package ui;

import dao.StudentDAO;
import model.Student;

public class StudentLoginTest {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        Student student = studentDAO.loginStudent(
                "rahul123@gmail.com",
                "test123"
        );

        if (student != null) {
            System.out.println("Login Successful!");
            System.out.println("Welcome " + student.getName());
        } else {
            System.out.println("Invalid Email or Password!");
        }
    }
}
