package ui;

import dao.CompanyDAO;
import model.Company;

import java.util.List;

public class CompanyViewTest {

    public static void main(String[] args) {

        CompanyDAO companyDAO = new CompanyDAO();

        List<Company> companies = companyDAO.getAllCompanies();

        for (Company company : companies) {

            System.out.println("Company : " + company.getCompanyName());
            System.out.println("Email : " + company.getEmail());
            System.out.println("Phone : " + company.getPhone());
            System.out.println("Website : " + company.getWebsite());

            System.out.println("----------------------------");
        }
    }
}