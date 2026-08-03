package ui;

import dao.JobDAO;
import model.Job;

public class JobRegistrationTest {

    public static void main(String[] args) {

        Job job = new Job(
                1,
                "Java Developer",
                "Looking for Java Backend Developer",
                650000,
                "Java, SQL, JDBC",
                "BCA",
                7.50,
                "Bangalore",
                "2026-09-30",
                0.0
        );

        JobDAO jobDAO = new JobDAO();

        boolean result = jobDAO.addJob(job);

        if (result) {
            System.out.println("Job Posted Successfully!");
        } else {
            System.out.println("Job Posting Failed!");
        }
    }
}