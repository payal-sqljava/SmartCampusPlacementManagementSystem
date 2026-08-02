package ui;

import dao.CompanyDAO;
import model.Company;

public class CompanyLoginTest {

    public static void main(String[] args) {

        CompanyDAO companyDAO = new CompanyDAO();

        Company company = companyDAO.loginCompany(
                "hr@infosys.com",
                "infosys123"
        );

        if (company != null) {
            System.out.println("Login Successful!");
            System.out.println("Welcome " + company.getCompanyName());
        } else {
            System.out.println("Invalid Email or Password!");
        }
    }
}