package ui;

import dao.JobDAO;
import model.Job;

public class JobUpdateTest {

    public static void main(String[] args) {

        Job job = new Job(
                1,
                "Senior Java Developer",
                "Java Backend Developer",
                900000,
                "Java, Spring Boot, MySQL",
                "BCA",
                7.5,
                "Pune",
                "2026-10-15",
                1.0
        );

        job.setJobId(1);

        JobDAO jobDAO = new JobDAO();

        boolean result = jobDAO.updateJob(job);

        if (result) {
            System.out.println("Job Updated Successfully!");
        } else {
            System.out.println("Job Update Failed!");
        }
    }
}