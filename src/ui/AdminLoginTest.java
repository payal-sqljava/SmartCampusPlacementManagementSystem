package ui;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginTest {

    public static void main(String[] args) {

        String email = "admin@gmail.com";
        String password = "admin123";

        String sql = "SELECT * FROM admins WHERE email=? AND password=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("Admin Login Successful!");
                System.out.println("Welcome " + rs.getString("name"));
            } else {
                System.out.println("Invalid Admin Credentials!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}