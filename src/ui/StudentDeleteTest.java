package ui;

import dao.StudentDAO;

public class StudentDeleteTest {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        boolean result = studentDAO.deleteStudent("rahul123@gmail.com");

        if (result) {
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }
}