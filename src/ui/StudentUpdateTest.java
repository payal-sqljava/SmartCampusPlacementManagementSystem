package ui;

import dao.StudentDAO;
import model.Student;

public class StudentUpdateTest {

    public static void main(String[] args) {

        Student student = new Student(
                "Rahul Sharma",
                "rahul123@gmail.com",
                "test123",
                "9999999999",
                "Male",
                "ABC College",
                "BCA",
                "Computer Applications",
                2025,
                9.20,
                "Java, SQL, Spring Boot",
                "rahul_resume.pdf",
                0.0,
                null
        );

        StudentDAO studentDAO = new StudentDAO();

        boolean result = studentDAO.updateStudent(student);

        if (result) {
            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student Update Failed!");
        }
    }
}
