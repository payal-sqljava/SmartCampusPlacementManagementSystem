package ui;

import dao.ApplicationDAO;
import model.Application;

public class ApplyJobTest {

    public static void main(String[] args) {

        Application application = new Application(
                3,   // Student ID
                1    // Job ID
        );

        ApplicationDAO applicationDAO = new ApplicationDAO();

        boolean result = applicationDAO.applyJob(application);

        if (result) {
            System.out.println("Job Applied Successfully!");
        } else {
            System.out.println("Job Application Failed!");
        }
    }
}