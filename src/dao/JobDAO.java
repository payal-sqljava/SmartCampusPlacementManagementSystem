package dao;

import model.Job;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Job> getAllJobs() {

        List<Job> jobs = new ArrayList<>();

        String sql = "SELECT * FROM jobs";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Job job = new Job(
                        resultSet.getInt("company_id"),
                        resultSet.getString("job_title"),
                        resultSet.getString("job_description"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("required_skills"),
                        resultSet.getString("required_course"),
                        resultSet.getDouble("minimum_cgpa"),
                        resultSet.getString("location"),
                        resultSet.getString("last_date"),
                        resultSet.getDouble("experience_required")
                );

                job.setJobId(resultSet.getInt("job_id"));

                jobs.add(job);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }
    public boolean deleteJob(int jobId) {

        String sql = "DELETE FROM jobs WHERE job_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, jobId);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateJob(Job job) {

        String sql = "UPDATE jobs SET " +
                "job_title=?, job_description=?, salary=?, required_skills=?, " +
                "required_course=?, minimum_cgpa=?, location=?, last_date=?, " +
                "experience_required=? WHERE job_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, job.getJobTitle());
            statement.setString(2, job.getJobDescription());
            statement.setDouble(3, job.getSalary());
            statement.setString(4, job.getRequiredSkills());
            statement.setString(5, job.getRequiredCourse());
            statement.setDouble(6, job.getMinimumCgpa());
            statement.setString(7, job.getLocation());
            statement.setString(8, job.getLastDate());
            statement.setDouble(9, job.getExperienceRequired());
            statement.setInt(10, job.getJobId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
