package ui;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentViewTest {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        List<Student> students = studentDAO.getAllStudents();

        for (Student student : students) {

            System.out.println("Name : " + student.getName());
            System.out.println("Email : " + student.getEmail());
            System.out.println("Phone : " + student.getPhone());
            System.out.println("Course : " + student.getCourse());
            System.out.println("CGPA : " + student.getCgpa());

            System.out.println("---------------------------");
        }
    }
}
