package dao;

import model.Company;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    // Registration Method
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

    // Login Method
    public Company loginCompany(String email, String password) {


        String sql = "SELECT * FROM companies WHERE email = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Company company = new Company(
                        resultSet.getString("company_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("website"),
                        resultSet.getString("location"),
                        resultSet.getString("industry"),
                        resultSet.getString("description")
                );

                return company;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<Company> getAllCompanies() {

        List<Company> companies = new ArrayList<>();

        String sql = "SELECT * FROM companies";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Company company = new Company(
                        resultSet.getString("company_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("website"),
                        resultSet.getString("location"),
                        resultSet.getString("industry"),
                        resultSet.getString("description")
                );

                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies;
    }
    public boolean updateCompany(Company company) {

        String sql = "UPDATE companies SET phone=?, website=?, location=?, industry=?, description=? WHERE email=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, company.getPhone());
            statement.setString(2, company.getWebsite());
            statement.setString(3, company.getLocation());
            statement.setString(4, company.getIndustry());
            statement.setString(5, company.getDescription());
            statement.setString(6, company.getEmail());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteCompany(String email) {

        String sql = "DELETE FROM companies WHERE email=?";

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