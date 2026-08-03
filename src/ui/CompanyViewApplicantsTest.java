package ui;

import dao.ApplicationDAO;

import java.util.List;

public class CompanyViewApplicantsTest {

    public static void main(String[] args) {

        ApplicationDAO dao = new ApplicationDAO();

        List<String> applicants = dao.viewApplicants();

        for (String applicant : applicants) {
            System.out.println(applicant);
        }
    }
}