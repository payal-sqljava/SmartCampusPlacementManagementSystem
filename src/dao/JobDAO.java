package dao;

import model.Job;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobDAO {
    public boolean addJob(Job job) {

        String sql = "INSERT INTO jobs " +
                "(company_id, job_title, job_description, salary, required_skills, required_course, minimum_cgpa, location, last_date, experience_required) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, job.getCompanyId());
            statement.setString(2, job.getJobTitle());
            statement.setString(3, job.getJobDescription());
            statement.setDouble(4, job.getSalary());
            statement.setString(5, job.getRequiredSkills());
            statement.setString(6, job.getRequiredCourse());
            statement.setDouble(7, job.getMinimumCgpa());
            statement.setString(8, job.getLocation());
            statement.setString(9, job.getLastDate());
            statement.setDouble(10, job.getExperienceRequired());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
