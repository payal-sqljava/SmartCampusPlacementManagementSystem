package dao;

import model.Application;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {
    public boolean applyJob(Application application) {

        String sql = "INSERT INTO applications (student_id, job_id) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, application.getStudentId());
            statement.setInt(2, application.getJobId());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<String> viewApplicants() {

        List<String> applicants = new ArrayList<>();

        String sql =
                "SELECT s.name, s.email, j.job_title, a.application_status " +
                        "FROM applications a " +
                        "JOIN students s ON a.student_id = s.student_id " +
                        "JOIN jobs j ON a.job_id = j.job_id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String data =
                        "Student : " + resultSet.getString("name") +
                                "\nEmail : " + resultSet.getString("email") +
                                "\nJob : " + resultSet.getString("job_title") +
                                "\nStatus : " + resultSet.getString("application_status") +
                                "\n-------------------------";

                applicants.add(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applicants;
    }
    public boolean updateApplicationStatus(int applicationId, String status) {

        String sql = "UPDATE applications SET application_status=? WHERE application_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, applicationId);

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<String> studentApplications(int studentId) {

        List<String> list = new ArrayList<>();

        String sql =
                "SELECT j.job_title, c.company_name, a.application_status " +
                        "FROM applications a " +
                        "JOIN jobs j ON a.job_id=j.job_id " +
                        "JOIN companies c ON j.company_id=c.company_id " +
                        "WHERE a.student_id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                list.add(
                        rs.getString("job_title") +
                                " | " +
                                rs.getString("company_name") +
                                " | " +
                                rs.getString("application_status")
                );

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return list;
    }

}