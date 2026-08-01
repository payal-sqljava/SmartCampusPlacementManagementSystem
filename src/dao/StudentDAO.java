package dao;
import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public boolean registerStudent(Student student) {
        String sql = "INSERT INTO students " +
                "(name, email, password, phone, gender, college_name, course, branch, " +
                "passing_year, cgpa, skills, resume_file, experience_years, last_company) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPassword());
            statement.setString(4, student.getPhone());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getCollegeName());
            statement.setString(7, student.getCourse());
            statement.setString(8, student.getBranch());
            statement.setInt(9, student.getPassingYear());
            statement.setDouble(10, student.getCgpa());
            statement.setString(11, student.getSkills());
            statement.setString(12, student.getResumeFile());
            statement.setDouble(13, student.getExperienceYears());
            statement.setString(14, student.getLastCompany());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Student registration failed: " + e.getMessage());
            return false;
        }

    }
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Student student = new Student(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("gender"),
                        resultSet.getString("college_name"),
                        resultSet.getString("course"),
                        resultSet.getString("branch"),
                        resultSet.getInt("passing_year"),
                        resultSet.getDouble("cgpa"),
                        resultSet.getString("skills"),
                        resultSet.getString("resume_file"),
                        resultSet.getDouble("experience_years"),
                        resultSet.getString("last_company")
                );

                students.add(student);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
    public Student loginStudent(String email, String password) {

        String sql = "SELECT * FROM students WHERE email = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Student student = new Student(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("gender"),
                        resultSet.getString("college_name"),
                        resultSet.getString("course"),
                        resultSet.getString("branch"),
                        resultSet.getInt("passing_year"),
                        resultSet.getDouble("cgpa"),
                        resultSet.getString("skills"),
                        resultSet.getString("resume_file"),
                        resultSet.getDouble("experience_years"),
                        resultSet.getString("last_company")
                );

                return student;
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean updateStudent(Student student) {

        String sql = "UPDATE students SET " +
                "phone = ?, " +
                "skills = ?, " +
                "cgpa = ? " +
                "WHERE email = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getPhone());
            statement.setString(2, student.getSkills());
            statement.setDouble(3, student.getCgpa());
            statement.setString(4, student.getEmail());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteStudent(String email) {

        String sql = "DELETE FROM students WHERE email = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
