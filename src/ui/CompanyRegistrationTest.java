package ui;

import dao.CompanyDAO;
import model.Company;

public class CompanyRegistrationTest {

    public static void main(String[] args) {

        Company company = new Company(
                "Infosys",
                "hr@infosys.com",
                "infosys123",
                "9876543210",
                "https://www.infosys.com",
                "Bangalore",
                "IT Services",
                "Leading IT services company"
        );

        CompanyDAO companyDAO = new CompanyDAO();

        boolean result = companyDAO.registerCompany(company);

        if (result) {
            System.out.println("Company Registered Successfully!");
        } else {
            System.out.println("Company Registration Failed!");
        }
    }
}