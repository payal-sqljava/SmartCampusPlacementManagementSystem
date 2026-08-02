package dao;

import model.Company;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class CompanyDAO {
        public boolean registerCompany(Company company) {

            String sql = "INSERT INTO companies " +
                    "(company_name, email, password, phone, website, location, industry, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, company.getCompanyName());
                statement.setString(2, company.getEmail());
                statement.setString(3, company.getPassword());
                statement.setString(4, company.getPhone());
                statement.setString(5, company.getWebsite());
                statement.setString(6, company.getLocation());
                statement.setString(7, company.getIndustry());
                statement.setString(8, company.getDescription());

                int rowsInserted = statement.executeUpdate();

                return rowsInserted > 0;

            } catch (SQLException e) {
                System.out.println("Company registration failed: " + e.getMessage());
                return false;
            }
        }

    }
