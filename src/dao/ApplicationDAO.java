package dao;

import model.Application;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}