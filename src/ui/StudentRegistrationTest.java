package ui;

import dao.StudentDAO;
import model.Student;

    public class StudentRegistrationTest{

        public static void main(String[] args) {

            Student student = new Student(
                    "Rahul Sharma",
                    "rahul123@gmail.com",
                    "test123",
                    "9876543210",
                    "Male",
                    "ABC College",
                    "BCA",
                    "Computer Applications",
                    2025,
                    8.25,
                    "Java, SQL, HTML, CSS",
                    "rahul_resume.pdf",
                    0.0,
                    null
            );

            StudentDAO studentDAO = new StudentDAO();

            boolean result = studentDAO.registerStudent(student);

            if (result) {
                System.out.println("Student registered successfully!");
            } else {
                System.out.println("Student registration failed!");
            }
        }
    }

